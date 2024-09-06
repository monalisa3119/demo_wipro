package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".\\Feature\\",
    glue = "stepdef",
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true, 
    dryRun = false 
    
)
 
public class Tesrrunner1 {

}
