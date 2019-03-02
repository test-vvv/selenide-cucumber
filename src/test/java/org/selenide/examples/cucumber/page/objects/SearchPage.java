package org.selenide.examples.cucumber.page.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public SelenideElement searchInput() {
        return $("input[type='text']");
    }

    public SelenideElement searchButton() {
        return $("#sbtn");
    }

    public SelenideElement searchFilter(String filter) {
        return $("[name='" + filter + "']");
    }

    public SelenideElement priceFilter(String border) {
        return $("[name='topt[8][" + border + "]']");
    }

}