package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/**
 * Classe Page Object Model (POM) para o cenário de teste UserStory11.
 * <p>
 * US11: Como jogador competitivo, quero um painel de gestão (My Tournaments),
 * para acompanhar as chaves, os resultados e o meu progresso nas competições
 * em que estou inscrito.
 * </p>
 * <p>
 * Esta classe isola os localizadores e as operações da página "My Tournaments",
 * permitindo navegar para o painel de gestão de torneios e verificar os
 * elementos presentes nessa secção.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory11 {

    /** Link para a secção "My Tournaments" no menu lateral de navegação. */
    public SelenideElement linkMeusTorneios = $("a[href='/en/t/my-tournaments']");

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
     * Navega para a secção "My Tournaments" (Os Meus Torneios) clicando no
     * link correspondente no menu lateral, utilizando JavaScript para
     * contornar possíveis sobreposições de anúncios.
     */
    public void navegarParaMeusTorneios() {
        linkMeusTorneios.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }
}
