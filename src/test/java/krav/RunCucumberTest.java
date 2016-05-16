package krav;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Denne filen kjører Cucumber testene og trengs for å kjøre steg definisjoner (både for Java og Groovy).
 */

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@wip" })
public class RunCucumberTest {
}
