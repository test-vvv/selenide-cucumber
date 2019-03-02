package org.selenide.examples.cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty","html:format"},
        features = "classpath:",
        glue = "org.selenide.examples.cucumber"
)
public class GenericTest {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.baseUrl = "https://www.ss.com";
        Configuration.timeout = 5000;
    }
}
