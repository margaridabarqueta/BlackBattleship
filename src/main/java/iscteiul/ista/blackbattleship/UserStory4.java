package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/**
 * Classe Page Object Model (POM) para o cenário de teste UserStory4.
 * <p>
 * US04: Como utilizador, quero adicionar outros jogadores à minha lista
 * de amigos, para ver quando estão online e desafiá-los facilmente.
 * </p>
 * <p>
 * Esta classe isola os localizadores e as operações da página de amigos,
 * permitindo navegar para a secção "Friends" e verificar os elementos
 * presentes nessa página.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory4 {

    /** Link para a secção "Friends" no menu lateral de navegação. */
    public SelenideElement linkAmigos = $("a[href='/en/friends']");

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
     * Navega para a secção "Friends" clicando no link correspondente
     * no menu lateral, utilizando JavaScript para contornar sobreposições.
     */
    public void navegarParaAmigos() {
        linkAmigos.scrollIntoView(true).click(ClickOptions.usingJavaScript());
    }
}
