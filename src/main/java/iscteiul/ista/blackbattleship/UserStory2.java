package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Classe Page Object Model (POM) para o cenário de teste UserStory2.
 * <p>
 * US02: Como jogador, quero selecionar células no tabuleiro do adversário
 * para efetuar disparos e tentar afundar a frota inimiga.
 * </p>
 * <p>
 * Esta classe isola os localizadores e as operações exclusivas da página
 * de jogo contra o robot, permitindo iniciar uma partida e verificar
 * a visibilidade do tabuleiro do adversário.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory2 {

    /** Botão "Play vs robot" na página principal do Battleship (span interior). */
    public SelenideElement botaoJogarContraRobot = $x("//span[text()='Play vs robot']");

    /** Campo de texto para introdução do nickname antes de jogar. */
    public SelenideElement campoNickname = $("input[formcontrolname='username']");

    /** Botão "Continue" ou "Play" para confirmar o nickname e avançar para o jogo. */
    public SelenideElement botaoContinuar = $("button[type='submit']");

    /** Contentor principal do tabuleiro de jogo (área de jogo). */
    public SelenideElement areaTabuleiro = $("app-game-landing");

    /**
     * Abre a página principal do jogo Battleship no browser.
     */
    public void abrirPagina() {
        open("https://papergames.io/en/battleship");
    }

    /**
     * Fecha eventuais popups de anúncios ou sobreposições que interfiram
     * com a interação dos elementos. Ignora silenciosamente se não existirem.
     */
    public void fecharPopups() {
        try {
            sleep(1000);
            // Tenta fechar qualquer overlay de anúncio
            executeJavaScript("document.querySelectorAll('.cdk-overlay-backdrop').forEach(e => e.click());");
        } catch (Exception e) {
            System.out.println("Sem popups para fechar.");
        }
    }

    /**
     * Clica no botão "Play vs robot" para iniciar uma partida contra o computador.
     * Utiliza JavaScript para contornar possíveis sobreposições de anúncios.
     */
    public void clicarJogarContraRobot() {
        botaoJogarContraRobot.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }

    /**
     * Introduz o nickname do jogador no campo de texto e confirma clicando no botão de submissão.
     *
     * @param nickname O nome a utilizar como identificação do jogador.
     */
    public void inserirNicknameEContinuar(String nickname) {
        campoNickname.clear();
        campoNickname.setValue(nickname);
        botaoContinuar.click(ClickOptions.usingJavaScript());
    }
}
