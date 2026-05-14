package iscteiul.ista.blackbattleship.tests_suite.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MobileAppSelenidePage {

    // O teu seletor original (recuperado da tua versão anterior)
    public SelenideElement botaoGooglePlay = $x("//img[@alt='Get it on Playstore']");

    // Ações da página
    public void openPage() {
        open("https://papergames.io/en/battleship");
    }

    public void clickGooglePlayButton() {
        // Faz o scroll e usa o clique mágico do JS para furar o anúncio
        botaoGooglePlay.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }
}