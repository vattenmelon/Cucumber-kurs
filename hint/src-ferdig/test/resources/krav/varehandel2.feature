#language: no

Egenskap: Varehandel [2]

  Bakgrunn:
    Gitt en prisliste for varer:
      | banan | 4 |
      | eple  | 5 |

  Scenario: Handle en vare
    Gitt at jeg tar 1 banan i handlekurven
    Når varene summeres av kassa
    Så skal totalprisen være 4 kr

  Scenario: Handle to like varer
    Gitt at jeg tar 2 bananer i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 8 kr

  Scenario: Handle diverse varer
    Gitt at jeg tar 1 banan i handlevogna
    Og jeg tar 2 epler i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 14 kr

  Scenario: Handle diverse varer fra tabell
    Gitt at jeg fyller handlevogna med følgende varer:
      | 1 | banan |
      | 2 | epler |
    Når varene summeres av kassa
    Så skal totalprisen være 14 kr

  Scenariomal: Handle masse varer
    Gitt at jeg tar <vare_1_antall> <vare_1_navn> i handlevogna
    Og jeg tar <vare_2_antall> <vare_2_navn> i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være <forventet_pris> kroner
    Eksempler:
      | vare_1_navn | vare_1_antall | vare_2_navn | vare_2_antall | forventet_pris |
      | banan       | 1             | eple        | 2             | 14             |
      | banan       | 4             | eple        | 1             | 21             |
      | eple        | 7             | banan       | 5             | 55             |
      | banan       | 7             | banan       | 5             | 48             |

