package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class UserStory1Test {

    UserStory1 us01Page = new UserStory1();

    // Configuração para o Allure apanhar os resultados e tirar screenshots em caso de erro
    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @Test
    @DisplayName("US01: Iniciar partida rápida contra o Robot com nickname automático")
    public void testIniciarPartidaVsRobot() {

        // 1. Abre a página
        open("https://papergames.io/en/battleship");

        // 2. Aceita cookies
        us01Page.acceptCookies();

        // 3. Clica no botão "Play vs robot"
        us01Page.btnPlayVsRobot
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        // 4. Escreve o nickname
        us01Page.inputNickname
                .shouldBe(Condition.interactable, Duration.ofSeconds(10))
                .click();
        us01Page.inputNickname.setValue("TestBot123");

        // 5. Clica em "Continue"
        us01Page.btnContinue
                .shouldBe(Condition.interactable)
                .click();

        // 6. Verifica que a partida iniciou
        // Verifica se fomos redirecionados para a sala
        webdriver().shouldHave(
                WebDriverConditions.urlContaining("/r/"),
                Duration.ofSeconds(15)
        );

        // Verifica se o teu nome (TestBot123) ou o nome do bot (Paper Man) aparecem no ecrã
        $("body").shouldHave(Condition.anyOf(
                Condition.text("TestBot123"),
                Condition.text("Paper Man")
        ), Duration.ofSeconds(10));
    }
}