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
 * Classe de testes para a User Story 14 (Acesso ao Portal de Developers).
 * Valida a navegação para a documentação externa da plataforma.
 */
public class UserStory14Test {

    private WebDriver driver;
    private UserStory14 us14Page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Abre a página principal
        driver.get("https://papergames.io/en/battleship");

        us14Page = new UserStory14(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAcederPortalDevelopers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String separadorOriginal = driver.getWindowHandle();

        // Faz scroll até ao fim da página para garantir que o link "Developers" no rodapé está visível
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Espera que o link fique clicável e faz o clique
        wait.until(ExpectedConditions.elementToBeClickable(us14Page.linkDevelopers)).click();

        // O link de Developers abre num novo separador, logo mudamos o foco
        Set<String> todosSeparadores = driver.getWindowHandles();
        for (String separador : todosSeparadores) {
            if (!separador.equals(separadorOriginal)) {
                driver.switchTo().window(separador);
                break;
            }
        }

        // Validação (Assert): Verifica se o URL do novo separador é o portal dos developers
        wait.until(ExpectedConditions.urlContains("developers.papergames"));
        assertTrue(driver.getCurrentUrl().contains("developers.papergames"), "O teste falhou: O portal para developers não abriu corretamente.");
    }
}