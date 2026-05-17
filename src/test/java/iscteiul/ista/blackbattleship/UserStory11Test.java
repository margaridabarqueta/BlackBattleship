package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

/**
 * Classe de teste (Page Test Class) para o cenário UserStory11.
 * <p>
 * US11: Como jogador competitivo, quero um painel de gestão (My Tournaments),
 * para acompanhar as chaves, os resultados e o meu progresso nas competições
 * em que estou inscrito.
 * </p>
 * <p>
 * Este teste verifica que o utilizador consegue aceder à página "My Tournaments"
 * a partir do menu lateral, confirmando que o URL é atualizado corretamente
 * para "/my-tournaments".
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory11Test {

    /** Instância da Page Object para a UserStory11. */
    UserStory11 us11Page = new UserStory11();

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
     * Testa a navegação para o painel de gestão de torneios (My Tournaments):
     * <ol>
     *   <li>Abre a página do Battleship</li>
     *   <li>Fecha popups (se presentes)</li>
     *   <li>Clica no link "My Tournaments" no menu lateral</li>
     *   <li>Verifica que o URL contém "/my-tournaments"</li>
     * </ol>
     */
    @Test
    @DisplayName("US11 — Verificar acesso ao painel de gestão de torneios (My Tournaments)")
    public void testAcederMeusTorneios() {
        us11Page.abrirPagina();
        sleep(3000);

        us11Page.fecharPopups();
        sleep(1500);

        // Espera explícita pelo link de My Tournaments na sidebar
        us11Page.linkMeusTorneios.shouldBe(visible, Duration.ofSeconds(10));
        us11Page.navegarParaMeusTorneios();
        sleep(2000);

        // Verifica que o URL contém "/my-tournaments"
        webdriver().shouldHave(urlContaining("my-tournaments"));

        System.out.println("US11: Painel 'My Tournaments' acedido com sucesso.");
        sleep(2000);
    }
}
