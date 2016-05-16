#language: no

Egenskap: Varehandel [1]

  Scenario: Handle en banan
    Gitt at en banan koster 4 kr
    Og jeg tar 1 banan i handlekurven
    Når varene summeres av kassa
    Så skal totalprisen være 4 kr

  Scenario: Handle to bananer
    Gitt at en banan koster 4 kr
    Og jeg tar 2 bananer i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 8 kr

  Scenario: Handle diverse varer
    Gitt at en banan koster 4 kr
    Og et eple koster 5 kr
    Og jeg tar 2 bananer i handlevogna
    Og jeg tar 1 eple i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 13 kr

  Scenario: Handle endel varer
    Gitt en prisliste for varer:
      | banan | 4 |
      | eple  | 5 |
      | pære  | 5 |
    Og jeg fyller handlevogna med følgende varer:
      | 1      | banan |
      | 2      | eple  |
      | 3      | pærer  |
    Når varene summeres av kassa
    Så skal totalprisen være 29 kr

