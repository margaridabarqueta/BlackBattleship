package iscteiul.ista.blackbattleship.tests_suite.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TournamentsSelenidePage {

    // Os teus seletores XPath originais (estão ótimos!)
    public SelenideElement abaTorneios = $x("//a[contains(@href, 'tournaments')]");
    public SelenideElement botaoCriarTorneio = $x("//span[contains(.,'Create tournament')]");

    // Ações da página
    public void openPage() {
        open("https://papergames.io/en/battleship");
    }

    public void openTournamentsTab() {
        abaTorneios.click(ClickOptions.usingJavaScript()); // Furar o anúncio
    }

    public void clickCreateTournament() {
        botaoCriarTorneio.click(ClickOptions.usingJavaScript()); // Furar o anúncio
    }
}