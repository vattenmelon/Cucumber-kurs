package ske.kurs.cucumber;

import java.util.Map.Entry;

public class Kasse {

    final Prisliste prisliste;
    int totalpris = 0;

    public Kasse(Prisliste prisliste) {
        this.prisliste = prisliste;
    }

    public void summerVarer(Handlekurv handlekurv) {
    	totalpris = 0;
        for (Entry<String, Integer> entry : handlekurv.mapVareAntall.entrySet()){
        	totalpris += entry.getValue() * prisliste.getPris(entry.getKey());
        }

    }

    public int getTotalpris() {
        return totalpris;
    }
}
