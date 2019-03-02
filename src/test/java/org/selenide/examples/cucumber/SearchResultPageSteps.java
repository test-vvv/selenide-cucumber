package org.selenide.examples.cucumber;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import cucumber.api.java.en.*;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.junit.Assert;
import org.selenide.examples.cucumber.page.objects.SearchResultPage;

import java.util.ArrayList;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;

@ScenarioScoped
public class SearchResultPageSteps {
    @Inject
    SearchResultPage resultPage;

    ArrayList<String> selectedAds = new ArrayList<>();

    @And("I should see ads from \"(.+)\" only")
    public void clickSearchButton(String city) {
        Selenide.screenshot("s");
        ElementsCollection results = resultPage.results();

        Assert.assertTrue("There is no results", results.size() > 0);

        for (SelenideElement result : results) {
            result.find(".ads_region").shouldHave(text(city));
        }
    }

    @And("I sort results by \"Price\"")
    public void sortByPrice() {
        resultPage.priceSorting().click();
    }

    @And("I filter results by \"(.+)\" with \"(.+)\" option")
    public void filterBy(String filterName, String option) {
        SelenideElement filterElement;
        filters filter = filters.valueOf(filterName.replace(" ", "_").toUpperCase());

        switch (filter) {
            case REGION:
                filterElement = resultPage.regionFilter();
                break;
            case DEAL_TYPE:
                filterElement = resultPage.dealTypeFilter();
                break;
            default:
                throw new RuntimeException("Wrong filter name provided");
        }
        filterElement.selectOption(option);
    }

    @And("I click \"Advanced search\" link")
    public void clickAdvancedLink() {
        resultPage.advancedSearchLink().click();
    }

    @And("I add selected ads to favorites")
    public void addSelectedAds() {
        resultPage.addToFavorites().scrollIntoView(true).click();
    }

    @And("I select (\\d+) random ads")
    public void clickAdvancedLink(int count) {
        ElementsCollection results = resultPage.results();
        int i = 0;
        int resultsCount = results.size();
        Random rand = new Random();


        while (i < count) {
            int n = rand.nextInt(resultsCount);
            SelenideElement result = results.get(n);

            result.find("input").scrollIntoView(true).click();
            selectedAds.add(result.find(".d1 a").getAttribute("id"));
            i++;
        }
    }

    public enum filters {
        REGION,
        DEAL_TYPE
    }
}
