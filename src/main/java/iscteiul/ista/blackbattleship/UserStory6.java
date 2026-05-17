package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/**
 * Classe Page Object Model (POM) para o cenário de teste UserStory6.
 * <p>
 * US06: Como jogador competitivo, quero consultar o meu histórico de partidas
 * (Match History), para analisar as minhas vitórias, derrotas e estatísticas
 * gerais na Batalha Naval.
 * </p>
 * <p>
 * Esta classe isola os localizadores e as operações da página de histórico
 * de partidas, permitindo navegar para a secção "History" e verificar os
 * elementos presentes nessa página.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory6 {

    /** Link para a secção "Match History" no menu lateral de navegação. */
    public SelenideElement linkHistorico = $("a[href='/en/match-history']");

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
            executeJavaScript("document.querySelectorAll('.cdk-overlay-backdrop').forEach(e => e.click());");
        } catch (Exception e) {
            System.out.println("Sem popups para fechar.");
        }
    }

    /**
     * Navega para a secção "History" (Histórico de Partidas) clicando no
     * link correspondente no menu lateral, utilizando JavaScript para
     * contornar possíveis sobreposições.
     */
    public void navegarParaHistorico() {
        linkHistorico.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }
}
