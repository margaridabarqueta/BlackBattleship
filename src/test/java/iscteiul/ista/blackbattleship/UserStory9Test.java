package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * Classe de testes para a User Story 9 (Aceder à Loja Virtual/Goodies).
 * Utiliza o padrão Page Object Model e JUnit 5 para validação.
 */
public class UserStory9Test {

    private WebDriver driver;
    private UserStory9 us9Page;

    /**
     * Configuração inicial antes da execução do teste.
     * Inicializa o Chrome, maximiza a janela e navega para a página alvo.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Inicialização da página (tal como gravado no Selenium IDE)
        driver.get("https://papergames.io/en/battleship");

        // Instancia a classe Page Object
        us9Page = new UserStory9(driver);
    }

    /**
     * Limpeza do ambiente após o teste.
     * Encerra o driver e fecha todas as janelas do browser associadas.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Cenário de Teste: Valida se o clique no link "Goodies" abre a loja num novo separador.
     */
    @Test
    public void testAcederLojaGoodies() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Guarda o ID do separador original da Batalha Naval
        String separadorOriginal = driver.getWindowHandle();

        Thread.sleep(2000);

        // Espera que o elemento exista na página
        WebElement botaoGoodies = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Goodies')]")));

        // Faz um clique forçado via JavaScript para ignorar o banner de cookies/anúncios
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botaoGoodies);
        Thread.sleep(2000);

        // O link "Goodies" abre num novo separador. Precisamos mudar o foco do driver para lá.
        Set<String> todosSeparadores = driver.getWindowHandles();
        for (String separador : todosSeparadores) {
            if (!separador.equals(separadorOriginal)) {
                driver.switchTo().window(separador);
                break;
            }
        }

        // Validação (Assert): Verifica se o novo URL pertence à loja da Papergames
        // Esperamos que o URL no novo separador contenha a palavra "papergames"
        wait.until(ExpectedConditions.urlContains("papergames"));
        assertTrue(driver.getCurrentUrl().contains("papergames"), "O teste falhou: O URL do novo separador não corresponde à loja da marca.");
    }
}