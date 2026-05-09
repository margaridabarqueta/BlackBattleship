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
    public void testAcederLojaGoodies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Guarda o ID do separador original da Batalha Naval
        String separadorOriginal = driver.getWindowHandle();

        // Espera que o elemento fique disponível e faz o clique no link "Goodies"
        wait.until(ExpectedConditions.elementToBeClickable(us9Page.goodiesLink)).click();

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