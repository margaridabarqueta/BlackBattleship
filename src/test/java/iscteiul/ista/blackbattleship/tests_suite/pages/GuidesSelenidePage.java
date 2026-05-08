package iscteiul.ista.blackbattleship.tests_suite.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GuidesSelenidePage {

    // No Selenide, usamos "$" para CSS Selectors e "$x" para XPaths!
    private SelenideElement linkGameGuides = $("a[href*='game-guides']");
    private SelenideElement btnConsent = $x("//*[text()='Consent' or contains(text(), 'Consent')]");

    public void openPage() {
        // O Selenide abre o browser automaticamente, não precisamos de passar o "driver"
        open("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {
        // Se o botão existir no ecrã, ele clica. Sem try-catch confusos!
        if (btnConsent.exists()) {
            btnConsent.click();
        }
    }

    public void goToGameGuides() {
        // Magia pura: faz scroll até ao elemento e clica nele! Sem JavascriptExecutor!
        linkGameGuides.scrollTo().shouldBe(visible).click();
    }
}