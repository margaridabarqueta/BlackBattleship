package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Classe de teste (Page Test Class) para o cenário UserStory2.
 * <p>
 * US02: Como jogador, quero selecionar células no tabuleiro do adversário
 * para efetuar disparos e tentar afundar a frota inimiga.
 * </p>
 * <p>
 * Este teste verifica que, após iniciar um jogo contra o robot com um nickname,
 * o tabuleiro de jogo é carregado e visível para o jogador, permitindo a
 * interação com as células do adversário.
 * </p>
 * <p>
 * Utiliza esperas explícitas do Selenide ({@code shouldBe(visible)}) antes de
 * cada interação com elementos dinâmicos, garantindo robustez face a estados
 * de carregamento, sobreposições de anúncios e transições de página.
 * </p>
 *
 * @author Aluno 122473
 */
public class UserStory2Test {

    /** Instância da Page Object para a UserStory2. */
    UserStory2 us02Page = new UserStory2();

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
     * Testa o fluxo completo de iniciar um jogo contra o robot:
     * <ol>
     *   <li>Abre a página do Battleship</li>
     *   <li>Fecha popups de anúncios (se presentes)</li>
     *   <li>Clica em "Play vs robot"</li>
     *   <li>Introduz um nickname e confirma</li>
     *   <li>Verifica que a área de jogo está visível</li>
     * </ol>
     */
    @Test
    @DisplayName("US02 — Verificar que o tabuleiro do adversário está visível após iniciar jogo contra robot")
    public void testTabuleiroAdversarioVisivel() {
        us02Page.abrirPagina();
        sleep(3000);

        us02Page.fecharPopups();
        sleep(1500);

        // Espera explícita antes de clicar no botão dinâmico
        us02Page.botaoJogarContraRobot.shouldBe(visible, Duration.ofSeconds(10));
        us02Page.clicarJogarContraRobot();
        sleep(2000);

        // Espera explícita pelo campo de nickname (elemento dinâmico do modal)
        us02Page.campoNickname.shouldBe(visible, Duration.ofSeconds(10));
        us02Page.inserirNicknameEContinuar("Teste122473");
        sleep(5000);

        // Verifica que a área de jogo está visível
        us02Page.areaTabuleiro.shouldBe(visible, Duration.ofSeconds(15));

        System.out.println("US02: Tabuleiro de jogo visível após iniciar partida contra robot.");
        sleep(3000);
    }
}
