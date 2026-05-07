package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Page Test Class enriquecida com tempos de espera para simular uso humano.
 */
public class UserStory3Test {
    private WebDriver driver;
    private UserStory3 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new UserStory3(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("US03: Simulação de navegação humana aos Guias")
    public void testUserStory3() throws InterruptedException {
        page.open();
        Thread.sleep(2500); // Pausa para leitura da página inicial

        page.acceptCookies();
        Thread.sleep(1500); // Pausa após fechar popup

        System.out.println("Humano a procurar o link dos guias...");
        Thread.sleep(2000); // Simula o tempo de procura visual

        page.goToGameGuides();

        System.out.println("Sucesso. A ler os guias...");
        Thread.sleep(5000); // Tempo para o humano ler o conteúdo
    }
}