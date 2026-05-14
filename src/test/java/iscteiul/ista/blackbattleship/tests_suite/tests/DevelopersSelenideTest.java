package iscteiul.ista.blackbattleship.tests_suite.tests;

import iscteiul.ista.blackbattleship.tests_suite.pages.DevelopersSelenidePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class DevelopersSelenideTest {

    DevelopersSelenidePage page = new DevelopersSelenidePage();

    @Test
    @DisplayName("US14 (Selenide): Aceder ao Portal de Developers")
    public void testAcederPortalDevelopers() {

        page.openPage();

        sleep(2000);

        page.clickDevelopersLink();

        sleep(2000);

        switchTo().window(1);

        webdriver().shouldHave(
                urlContaining("developers.papergames")
        );
    }
}