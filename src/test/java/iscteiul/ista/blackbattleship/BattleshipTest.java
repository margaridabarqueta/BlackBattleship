package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BattleshipTest {

    private WebDriver driver;
    private iscteiul.ista.blackbattleship.BattleshipPage page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        page = new iscteiul.ista.blackbattleship.BattleshipPage(driver);
        page.open();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("US01: Implementa teste de inicio de jogo contra robot")
    public void testPlayBot() throws InterruptedException {
        System.out.println("A aguardar o campo de batalha...");
        Thread.sleep(4000);

        try {
            org.openqa.selenium.WebElement cookieButton = driver.findElement(By.xpath("//*[text()='Consent' or contains(text(), 'Consent')]"));
            org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookieButton);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Aviso de cookies não interferiu...");
        }

        System.out.println("A clicar em Play vs Robot...");
        page.clickPlayBot();
        Thread.sleep(2000);

        System.out.println("A inserir o Nickname da Comandante...");
        page.enterNickname("Marga");
        Thread.sleep(3000);

        Thread.sleep(10000);
    }

    @Test
    @DisplayName("US03: Aceder aos Guias de Jogo")
    public void testGameGuides() throws InterruptedException {
        System.out.println("A iniciar missão US03...");
        Thread.sleep(4000);

        try {
            org.openqa.selenium.WebElement cookieButton = driver.findElement(By.xpath("//*[text()='Consent' or contains(text(), 'Consent')]"));
            org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookieButton);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Sem cookies no radar...");
        }

        System.out.println("A navegar para os Guias de Jogo...");
        page.goToGuides();
        Thread.sleep(5000);
    }

}