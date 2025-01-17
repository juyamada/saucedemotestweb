package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
    features = { "src/test/resources/features" }, // caminho para a feature
    glue =     { "steps" },                       // caminho para a automação
    dryRun = false,                               // configuração do log 
    monochrome = true

) 
public class Runner {
    
}
