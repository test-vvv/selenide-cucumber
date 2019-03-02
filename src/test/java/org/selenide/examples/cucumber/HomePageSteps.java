package org.selenide.examples.cucumber;

import com.google.inject.Inject;
import cucumber.api.java.en.*;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.selenide.examples.cucumber.page.objects.HomePage;

@ScenarioScoped
public class HomePageSteps {

    @Inject
    public HomePage homePage;

    @When("I click \"(.+)\" link from main panel")
    public void clickLinkMainPanel(String linkName) {
        homePage.mainMenuLink(linkName).scrollIntoView(true).click();
    }

    @When("I click \"(.+)\" main category link")
    public void clickCategoryLink(String linkName) {
        homePage.categoryLink(linkName).click();
    }

    @And("I switch language")
    public void switchLang() {
        homePage.languageButton().click();
    }

    @And("I accept cookies")
    public void acceptCookies() {
        homePage.acceptCookieButton().click();
    }
}
