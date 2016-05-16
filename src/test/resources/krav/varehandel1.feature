#language: no

Egenskap: Varehandel 1

  Brukerhistorie: <navn>
  Som         <rolle/aktør/persona>
  Ønsker jeg  <behov>
  Slik at     <verdi>

  @wip
  Scenario: Handle en banan
    # TODO Oppgave 1: lag Stegdefinisjoner for disse stegene:
    Gitt at en banan koster 4 kr
    Og jeg tar 1 banan i handlekurven
    Når varene summeres av kassa
    Så skal totalprisen være 4 kr
  
  @wip
  Scenario: Handle to bananer
    # TODO Oppgave 2: gjenbruk Stegdefinisjonene - med små justeringer (banan|bananer)
    Gitt at en banan koster 4 kr
    Og jeg tar 2 bananer i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 8 kr

  @wip
  Scenario: Handle to bananer og ett eple
    # TODO Oppgave 3:
    Gitt at en banan koster 4 kr
    Og et eple koster 5 kr
    Og jeg tar 2 bananer i handlevogna
    Og jeg tar 1 eple i handlevogna
    Når varene summeres av kassa
    Så skal totalprisen være 13 kr

  Scenario: Handle diverse fra en liste av varer
    # TODO Oppgave 4: Datatabell som parameter til Stegdefinisjonene
    Gitt en prisliste for varer:
      | banan | 4 |
      | eple  | 5 |
      | pære  | 5 |
    Og jeg fyller handlevogna med følgende varer:
      | 1 | banan |
      | 2 | eple  |
      | 3 | pærer |
    Når varene summeres av kassa
    Så skal totalprisen være 29 kr

