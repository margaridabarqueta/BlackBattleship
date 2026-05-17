package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

/**
 * Classe de teste (Page Test Class) para o cenário UserStory6.
 * <p>
 * US06: Como jogador competitivo, quero consultar o meu histórico de partidas
 * (Match History), para analisar as minhas vitórias, derrotas e estatísticas
 * gerais na Batalha Naval.
 * </p>
 * <p>
 * Este teste verifica que o utilizador consegue aceder à página de histórico
 * de partidas a partir do menu lateral, confirmando que o URL é atualizado
 * corretamente para "/match-history".
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory6Test {

    /** Instância da Page Object para a UserStory6. */
    UserStory6 us06Page = new UserStory6();

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
     * Testa a navegação para a secção de histórico de partidas (Match History):
     * <ol>
     *   <li>Abre a página do Battleship</li>
     *   <li>Fecha popups (se presentes)</li>
     *   <li>Clica no link "History" no menu lateral</li>
     *   <li>Verifica que o URL contém "/match-history"</li>
     * </ol>
     */
    @Test
    @DisplayName("US06 — Verificar acesso ao histórico de partidas através do menu lateral")
    public void testAcederHistoricoPartidas() {
        us06Page.abrirPagina();
        sleep(3000);

        us06Page.fecharPopups();
        sleep(1500);

        // Espera explícita pelo link de histórico na sidebar
        us06Page.linkHistorico.shouldBe(visible, Duration.ofSeconds(10));
        us06Page.navegarParaHistorico();
        sleep(2000);

        // Verifica que o URL contém "/match-history"
        webdriver().shouldHave(urlContaining("match-history"));

        System.out.println("US06: Página de histórico de partidas acedida com sucesso.");
        sleep(2000);
    }
}
