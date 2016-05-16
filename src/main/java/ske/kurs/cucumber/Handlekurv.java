package ske.kurs.cucumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Handlekurv {

    Map<String, Integer> mapVareAntall = new HashMap<>();

    public void leggTil(String varen, int antall) {
        final int fraFør = getAntall(varen);
        mapVareAntall.put(varen, fraFør + antall);
    }

    public int getAntall(String varen) {
        return mapVareAntall.containsKey(varen) ? mapVareAntall.get(varen) : 0;
    }

    public Iterator<String> getIterator() {
        return mapVareAntall.keySet().iterator();
    }
}
