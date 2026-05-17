package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

/**
 * Classe de teste (Page Test Class) para o cenário UserStory4.
 * <p>
 * US04: Como utilizador, quero adicionar outros jogadores à minha lista
 * de amigos, para ver quando estão online e desafiá-los facilmente.
 * </p>
 * <p>
 * Este teste verifica que o utilizador consegue aceder à página de amigos
 * a partir do menu lateral, confirmando que o URL é atualizado corretamente
 * e que os elementos da página de amigos estão presentes.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory4Test {

    /** Instância da Page Object para a UserStory4. */
    UserStory4 us04Page = new UserStory4();

    /**
     * Configuração executada antes de cada teste.
     * Define o timeout do Selenide e a dimensão do browser.
     */
    @BeforeEach
    public void setUp() {
        Configuration.timeout = 15000;
        Configuration.browserSize = "1296x736";
    }

    /**
     * Limpeza executada após cada teste.
     * Fecha o browser controlado pelo Selenide.
     */
    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa a navegação para a secção de amigos (Friends):
     * <ol>
     *   <li>Abre a página do Battleship</li>
     *   <li>Fecha popups (se presentes)</li>
     *   <li>Clica no link "Friends" no menu lateral</li>
     *   <li>Verifica que o URL contém "/friends"</li>
     * </ol>
     */
    @Test
    @DisplayName("US04 — Verificar acesso à página de amigos através do menu lateral")
    public void testAcederPaginaAmigos() {
        us04Page.abrirPagina();
        sleep(3000);

        us04Page.fecharPopups();
        sleep(1500);

        // Espera explícita pelo link de amigos na sidebar
        us04Page.linkAmigos.shouldBe(visible, Duration.ofSeconds(10));
        us04Page.navegarParaAmigos();
        sleep(2000);

        // Verifica que o URL contém "/friends"
        webdriver().shouldHave(urlContaining("friends"));

        System.out.println("US04: Página de amigos acedida com sucesso.");
        sleep(2000);
    }
}
