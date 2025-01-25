package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
    features = { "src/test/resources/features" }, // caminho para a feature
    glue =     { "steps" },                       // caminho para a automação
    plugin = {"pretty", 
              "html:target/cucumber-reports.html", // adicionei saída formatada
              "json:target/cucumber-reports/cucumber.json" // Relatório JSON
},             
    dryRun = true,                               // configuração do log 
    monochrome = true

) 
public class Runner {
    
}
