package org.selenide.examples.cucumber;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import cucumber.api.java.en.*;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.selenide.examples.cucumber.page.objects.SearchPage;

@ScenarioScoped
public class SearchPageSteps {

    @Inject
    public SearchPage searchPage;


    @When("I enter \"(.+)\" to search input field")
    public void enterToSearchField(String input) {
        searchPage.searchInput().sendKeys(input);
    }

    @When("I click \"Search\" button")
    public void clickSearchButton() {
        searchPage.searchButton().click();
    }


    @When("I set price filter min \"(.+)\" max \"(.+)\"")
    public void setPriceFilter(String min, String max) {
        searchPage.priceFilter("min").sendKeys(min);
        searchPage.priceFilter("max").sendKeys(max);
    }


    @When("I choose \"(.+)\" option for \"(.+)\" filter")
    public void chooseOptionFrom(String option, String filter) {
        SelenideElement filterElement;
        searchFilters filterName = searchFilters.valueOf(filter.toUpperCase());


        switch (filterName) {
            case TYPE:
                filterElement = searchPage.searchFilter("sid");
                break;
            case CITY:
                filterElement = searchPage.searchFilter("search_region");
                break;
            case PERIOD:
                filterElement = searchPage.searchFilter("pr");
                break;
            case SORT:
                filterElement = searchPage.searchFilter("sort");
                break;
            default:
                throw new RuntimeException("Wrong filter type provided");
        }

        filterElement.selectOptionByValue(option);
    }

    public enum searchFilters {
        TYPE,
        CITY,
        PERIOD,
        SORT
    }
}
