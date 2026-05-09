package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * Classe de testes para a User Story 13 (Download App Mobile).
 * Garante que o botão de redirecionamento para a loja de aplicações funciona corretamente.
 */
public class UserStory13Test {

    private WebDriver driver;
    private UserStory13 us13Page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Abre a página principal do Battleship
        driver.get("https://papergames.io/en/battleship");

        us13Page = new UserStory13(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAcederGooglePlay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String separadorOriginal = driver.getWindowHandle();

        // Faz um pequeno scroll para garantir que o botão da Google Play está visível no ecrã
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");

        // Espera pelo botão da Playstore e clica
        wait.until(ExpectedConditions.elementToBeClickable(us13Page.botaoGooglePlay)).click();

        // Muda o foco do WebDriver para o novo separador da loja de apps
        Set<String> todosSeparadores = driver.getWindowHandles();
        for (String separador : todosSeparadores) {
            if (!separador.equals(separadorOriginal)) {
                driver.switchTo().window(separador);
                break;
            }
        }

        // Validação (Assert): Verifica se o URL contém "play.google.com"
        wait.until(ExpectedConditions.urlContains("play.google"));
        assertTrue(driver.getCurrentUrl().contains("play.google"), "O teste falhou: O redirecionamento para a Play Store não ocorreu.");
    }
}