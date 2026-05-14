package iscteiul.ista.blackbattleship.tests_suite.tests;

import iscteiul.ista.blackbattleship.tests_suite.pages.MobileAppSelenidePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MobileAppSelenideTest {

    MobileAppSelenidePage page = new MobileAppSelenidePage();

    @Test
    @DisplayName("US13 (Selenide): Aceder à Google Play Store")
    public void testAcederGooglePlay() {

        page.openPage();

        sleep(2000);

        page.clickGooglePlayButton();

        sleep(2000);

        switchTo().window(1);

        webdriver().shouldHave(
                urlContaining("play.google")
        );
    }
}