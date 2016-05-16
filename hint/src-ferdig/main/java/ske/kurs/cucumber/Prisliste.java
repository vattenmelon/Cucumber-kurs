package ske.kurs.cucumber;

import java.util.HashMap;
import java.util.Map;

public class Prisliste {

    Map<String, Integer> mapVarePris = new HashMap<>();

    public void registrerPris(String varen, int pris) {
        mapVarePris.put(varen, pris);
    }

    public int getPris(String varen) {
        if (mapVarePris.get(varen) == null) {
            throw new IllegalStateException("Fant ikke varen: " + varen);
        };
        return mapVarePris.get(varen);
    }
}
