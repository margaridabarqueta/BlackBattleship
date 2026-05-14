package iscteiul.ista.blackbattleship.tests_suite.tests;

import iscteiul.ista.blackbattleship.tests_suite.pages.TournamentsSelenidePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class TournamentsSelenideTest {

    TournamentsSelenidePage page = new TournamentsSelenidePage();

    @Test
    @DisplayName("US10 (Selenide): Aceder à criação de torneios")
    public void testAcederCriacaoTorneio() {

        page.openPage();

        sleep(2000);

        page.openTournamentsTab();

        sleep(2000);

        page.clickCreateTournament();

        webdriver().shouldHave(
                urlContaining("create")
        );
    }
}