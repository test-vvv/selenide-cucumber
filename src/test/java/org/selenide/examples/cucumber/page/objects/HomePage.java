package org.selenide.examples.cucumber.page.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement mainMenuLink(String link) {
        return $(".menu_main [href*='" + link + "']");
    }
    public SelenideElement categoryLink(String link) {
        return $("h2 [href*='" + link + "']");
    }

    public SelenideElement languageButton() {
        return $(".menu_lang > a");
    }

    public SelenideElement acceptCookieButton() {
        return $("#cookie_confirm_dv button");
    }
}
