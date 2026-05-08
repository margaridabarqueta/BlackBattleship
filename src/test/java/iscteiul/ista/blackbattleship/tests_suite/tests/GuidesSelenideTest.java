package iscteiul.ista.blackbattleship.tests_suite.tests;

import iscteiul.ista.blackbattleship.tests_suite.pages.GuidesSelenidePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class GuidesSelenideTest {

    GuidesSelenidePage page = new GuidesSelenidePage();

    @Test
    @DisplayName("US03 (Selenide): Aceder aos Guias de Jogo")
    public void testGameGuidesWithSelenide() {

        page.openPage();
        page.acceptCookies();
        page.goToGameGuides();

        // Pausa apenas para a Comandante conseguir ver o resultado final com os próprios olhos
        sleep(5000);
    }
}