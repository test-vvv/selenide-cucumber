package org.selenide.examples.cucumber.page.objects;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class FavoritePage {
    public ElementsCollection favorites() {
        return $$(".d1 a");
    }
}