REM .
REM opprett clazz katalog for kompilerte java filer
rmdir clazz /s /q
mkdir clazz
REM Kompilérer java filer og legger dem på katalogen clazz
javac -encoding UTF-8 -cp "../cucumber-jars/*" -d clazz src/main/java/ske/kurs/cucumber/*.java src/test/java/krav/VarehandelStegDef.java
REM Kjører Cucumber med kun scenario med @wip tag (classpath inkluderer cucumber-jars og clazz)
java -cp "../cucumber-jars/*;clazz" cucumber.api.cli.Main --plugin pretty --glue krav --tags @wip src/test/resources/krav/varehandel1.feature
