package iscteiul.ista.blackbattleship.tests_suite.tests;

import iscteiul.ista.blackbattleship.tests_suite.pages.GoodiesSelenidePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class GoodiesSelenidePageTest {

    GoodiesSelenidePage page = new GoodiesSelenidePage();

    @Test
    @DisplayName("US09 (Selenide): Aceder à loja de merchandising")
    public void testGoodiesStore() {

        page.openPage();

        sleep(2000);

        page.openGoodiesStore();

        switchTo().window(1);

        webdriver().shouldHave(
                urlContaining("merch.papergames.io")
        );

        sleep(3000);
    }
}