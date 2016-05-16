package ske.kurs.cucumber;

import java.util.Iterator;

public class Kasse {

    final Prisliste prisliste;
    int totalpris = 0;

    public Kasse(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public void summerVarer(Handlekurv handlekurv) {

        final Iterator<String> iterator = handlekurv.getIterator();
        while (iterator.hasNext()) {
            final String varen = iterator.next();
            totalpris += handlekurv.getAntall(varen) * prisliste.getPris(varen);
        }
    }

    public int getTotalpris() {
        return totalpris;
    }
}
