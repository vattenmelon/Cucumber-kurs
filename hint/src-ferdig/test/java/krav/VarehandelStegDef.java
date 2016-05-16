package krav;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;
import gherkin.formatter.model.DataTableRow;
import ske.kurs.cucumber.Handlekurv;
import ske.kurs.cucumber.Kasse;
import ske.kurs.cucumber.Prisliste;

public class VarehandelStegDef {

    Prisliste prisliste = new Prisliste();
    Handlekurv handlekurv = new Handlekurv();
    Kasse kasse = new Kasse(prisliste);

    @Gitt("^en prisliste for varer:$")
    public void gittEnPrislisteForVarer(Map<String, Integer> datatabell) throws Throwable {

        for (String varen : datatabell.keySet()) {
            prisliste.registrerPris(varen, datatabell.get(varen));
        }
    }

    @Gitt("^(?:at )?(?:en|ei|et) (.*) koster (\\d+) kr$")
    public void gittAtEnVareKoster(String vare, int pris) throws Throwable {
        prisliste.registrerPris(vare, pris);
    }

    @Gitt("^(?:at )?jeg tar (\\d+) (.*) i handle(?:kurven|vogna)$")
    public void gittVareIHandlekurven(int antall, String vare) throws Throwable {

        handlekurv.leggTil(finnVarenavnEntall(antall, vare), antall);
    }

    @Gitt("^(?:at )?jeg fyller handlevogna med følgende varer:$")
    public void gittJegFyllerHandlevognaMed(DataTable datatabell) throws Throwable {

        for (DataTableRow row : datatabell.getGherkinRows()) {
            final Integer antall = Integer.parseInt(row.getCells().get(0));
            final String varenavn = row.getCells().get(1);

            // Kunne gjenbruke følgende stegdefinisjon: gittVareIHandlekurven(antall, varenavn);

            handlekurv.leggTil(finnVarenavnEntall(antall, varenavn), antall);
        }
    }

    @Når("^varene summeres av kassa$")
    public void nårVareneSummeresAvKassa() throws Throwable {

        kasse.summerVarer(handlekurv);
    }

    @Så("^skal totalprisen være (\\d+) kr")
    public void såSkalTotalprisenVæreKr(int forventetPris) throws Throwable {

        assertEquals(forventetPris, kasse.getTotalpris());
    }


    private String finnVarenavnEntall(int antall, String vare) {
        String varenavn = vare;
        if (vare.endsWith("er") && antall > 1) {
            varenavn = vare.substring(0, vare.length() - 2);
            try {
                prisliste.getPris(varenavn);
            } catch (Exception e) {
                varenavn = vare.substring(0, vare.length() - 1);
            }

        }
        return varenavn;
    }

}
