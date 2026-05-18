package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class UserStory1 {

    public void acceptCookies() {
        // Localizador flexível: Procura pela classe técnica do banner ou por palavras comuns (Inglês/Português)
        SelenideElement btnCookiesFlexivel = $x("//button[contains(@class, 'fc-cta-consent') or contains(., 'Consent') or contains(., 'consent') or contains(., 'Accept') or contains(., 'Aceitar')]");

        try {
            System.out.println("À procura do banner de cookies...");
            // Espera até 10 segundos que o botão apareça e esteja pronto a ser clicado
            btnCookiesFlexivel.shouldBe(Condition.interactable, Duration.ofSeconds(10));

            // Força o clique no botão
            executeJavaScript("arguments[0].click();", btnCookiesFlexivel);
            System.out.println("Cookies fechados com sucesso!");

            // CRÍTICO: Espera até 3 segundos que a janela dos cookies desapareça do ecrã
            // Isto garante que o jogo não está "tapado" quando tentarmos clicar em "Play vs Robot"
            btnCookiesFlexivel.should(Condition.disappear, Duration.ofSeconds(3));

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Aviso: O banner de cookies não foi encontrado em 10s. Pode já ter sido aceite.");
        }
    }

    // Botão "Play vs robot"
    public SelenideElement btnPlayVsRobot = $x("//span[contains(text(),'Play vs robot')]");

    // Campo de nickname no modal
    public SelenideElement inputNickname = $("input[placeholder='Nickname']");

    // Botão "Continue"
    public SelenideElement btnContinue = $("button[type='submit'].btn-secondary");
}