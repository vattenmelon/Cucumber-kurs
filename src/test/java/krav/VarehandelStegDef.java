package krav;

import java.util.Map;
import java.util.Map.Entry;

import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;

import org.junit.Assert;

import ske.kurs.cucumber.Handlekurv;
import ske.kurs.cucumber.Kasse;
import ske.kurs.cucumber.Prisliste;

public class VarehandelStegDef {

	Prisliste prisliste = new Prisliste();
	Handlekurv handlekurv = new Handlekurv();
	Kasse kasse = new Kasse(prisliste);
	
	@Gitt("^en prisliste for varer:$")
	public void gittEnPrislisteForVarer(Map<String, Integer> priser){
		for (Entry<String, Integer> entry : priser.entrySet()){
			prisliste.registrerPris(entry.getKey(), entry.getValue());
		}
	}
	
    @Gitt("^(?:at en|et) (\\S+) koster (\\d+) kr$")
    public void at_en_vare_koster_kr(String vare, int pris) throws Throwable {
     
       prisliste.registrerPris(vare, pris);
    }
    
    @Gitt("^at jeg fyller handlevogna med følgende varer:$")
    public void at_jeg_fyller_handlevogna_med_foelgende_varer(Map<Integer, String> varer){
    	for (Entry<Integer, String> entry : varer.entrySet()){
    		legg_til_i_handlekurv(entry.getValue(), entry.getKey());
    	}
    }

    @Gitt("^(?:at |)jeg tar (\\d+) banan(?:|er) i handle(?:kurven|vogna)$")
    public void jeg_tar_banan_i_handlekurven(int antall) throws Throwable {
    	this.legg_til_i_handlekurv("banan", antall);
    }
    
    @Gitt("^(?:at |)jeg tar (\\d+) epl(?:e|er) i handle(?:kurven|vogna)$")
    public void jeg_tar_eple_i_handlekurven(int antall) throws Throwable {
    	this.legg_til_i_handlekurv("eple", antall);
    }
    
    public void legg_til_i_handlekurv(String vare, int antall){
    	handlekurv.leggTil(vare, antall);
    }

    @Når("^(?:Når|)varene summeres av kassa$")
    public void varene_summeres_av_kassa() throws Throwable {

        kasse.summerVarer(handlekurv);
    }

    @Så("^skal totalprisen være (\\d+) (?:kroner|kr)$")
    public void skal_totalprisen_være_kr(int forventetPris) throws Throwable {

        int totalprisen = kasse.getTotalpris();
        Assert.assertEquals(forventetPris, totalprisen);
    }


}
