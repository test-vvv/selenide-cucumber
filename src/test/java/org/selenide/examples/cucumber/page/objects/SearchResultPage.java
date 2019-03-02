package org.selenide.examples.cucumber.page.objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    public SelenideElement resultsTable() {
        return $("head_line").parent();
    }

    public ElementsCollection results() {
        return $$("[id*=\"tr_\"][style^=\"cursor\"]");
    }

    public SelenideElement priceSorting() {
        return $("#head_line .msg_column_td");
    }

    public SelenideElement regionFilter() {
        return $("#region_select");
    }

    public SelenideElement dealTypeFilter() {
        return $("[name=\"sid\"]");
    }

    public SelenideElement advancedSearchLink() {
        return $("tbody a[href*='search/']");
    }

    public SelenideElement addToFavorites() {
        return $("#a_fav_sel");
    }
}