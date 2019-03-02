package org.selenide.examples.cucumber;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.selenide.examples.cucumber.page.objects.FavoritePage;

@ScenarioScoped
public class FavoritePageSteps {
    @Inject
    SearchResultPageSteps resultPageSteps;

    @Inject
    FavoritePage favoritePage;

    @And("I should see the same ads")
    public void clickSearchButton() {
        for(String id : resultPageSteps.selectedAds) {
            checkFavorites(id);
        }
    }

    private void checkFavorites(String id) {
        for (SelenideElement favorite : favoritePage.favorites()) {
            if (favorite.attr("id").equals(id)) {
                return;
            }
        }
        throw new RuntimeException("Selected element is not found in favorites");
    }
}
