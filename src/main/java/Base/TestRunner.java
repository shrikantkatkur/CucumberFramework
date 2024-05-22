package Base;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//
//@RunWith for Junit
@Test
@CucumberOptions(features ="src/test/resources/features",
glue="nop_Commerce_BDD.stepDef",//to attach step def
dryRun=false,plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})//to check all def are correctly written or run without running all scenarios)
public class TestRunner extends AbstractTestNGCucumberTests {

}
 