package org.selenide.examples.cucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.google.inject.Inject;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.selenide.examples.cucumber.helpers.Wait;
import org.selenide.examples.cucumber.page.objects.HomePage;
import org.selenide.examples.cucumber.page.objects.SearchPage;
import org.selenide.examples.cucumber.page.objects.SearchResultPage;

import static com.codeborne.selenide.Selenide.*;

@ScenarioScoped
public class CommonSteps {
    @Inject
    SearchPage searchPage;
    @Inject
    SearchResultPage searchResultPage;


    @Given("I open browser with ss.com home page")
    public void openHomePage() {
        open("/", HomePage.class);
    }

    @Given("I open browser with ss.com mobile home page")
    public void openHomePageMob() {
        open("https://m.ss.com/ru/", HomePage.class);
    }

    @After
    public static void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            screenshot(scenario.getName());
      }
    }

    @Then("I should see \"(.+)\" page loaded")
    public void searchPageILoaded(String pageName) {
        SelenideElement elementToCheck;

        Wait.waitDocumentToCompleteLoading(10);

        Pages page = Pages.valueOf(pageName.replace(" ", "_").toUpperCase());
        switch (page) {
            case SEARCH:
                elementToCheck = searchPage.searchInput();
                break;
            case SEARCH_RESULTS:
                elementToCheck = searchResultPage.resultsTable();
                break;
            case FAVORITES:
                elementToCheck = searchResultPage.resultsTable();
                break;
            default:
                throw new RuntimeException("Wrong page name provided");
        }

        elementToCheck.isDisplayed();
    }

    public enum Pages {
        SEARCH,
        SEARCH_RESULTS,
        FAVORITES
    }
}
