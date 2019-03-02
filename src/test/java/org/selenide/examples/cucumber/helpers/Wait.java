package org.selenide.examples.cucumber.helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class Wait {
    public static void waitDocumentToCompleteLoading(int seconds) {
        int i = 0;
        while (i < seconds) {
            if (executeJavaScript("return document.readyState").equals("complete")) {
                return;
            }
            sleep(200);
            i++;
        }
        throw new RuntimeException("Failed to load page completely, waited seconds " + seconds);
    }
}
