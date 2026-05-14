package iscteiul.ista.blackbattleship.tests_suite.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DevelopersSelenidePage {

    // O teu seletor original
    public SelenideElement linkDevelopers = $x("//a[contains(@href, 'developers.papergames.io')]");

    // Ações da página
    public void openPage() {
        open("https://papergames.io/en/battleship");
    }

    public void clickDevelopersLink() {
        // Faz o scroll e usa o clique mágico do JS
        linkDevelopers.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }
}