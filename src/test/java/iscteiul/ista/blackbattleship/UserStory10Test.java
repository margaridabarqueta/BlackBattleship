package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Classe de testes para a User Story 10 (Criar Torneio Personalizado).
 * Utiliza o padrão Page Object Model e JUnit 5 para garantir que
 * a funcionalidade de criar torneios está acessível.
 */
public class UserStory10Test {

    private WebDriver driver;
    private UserStory10 us10Page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Abre diretamente a página do jogo Battleship
        driver.get("https://papergames.io/en/battleship");

        us10Page = new UserStory10(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAcederCriacaoTorneio() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Clica no separador de Torneios no menu lateral
        wait.until(ExpectedConditions.elementToBeClickable(us10Page.abaTorneios)).click();

        // 2. Espera que o botão de "Create tournament" apareça e clica nele
        wait.until(ExpectedConditions.elementToBeClickable(us10Page.botaoCriarTorneio)).click();

        // 3. Validação (Assert): Verifica se o formulário abriu corretamente
        // Sabemos que abriu se o URL mudar para a página de criação de torneios
        wait.until(ExpectedConditions.urlContains("create"));
        assertTrue(driver.getCurrentUrl().contains("create"), "O teste falhou: Não foi possível aceder à janela de criação de torneio.");
    }
}