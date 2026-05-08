package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ch2-container")));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("""
                let popup = document.querySelector('.ch2-container');
                if (popup) {
                    popup.remove();
                }
            """);
        } catch (Exception e) {
            System.out.println("Nenhum banner de cookies encontrado.");
        }

        mainPage = new MainPage(driver);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() throws InterruptedException {

        mainPage.searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='wt-site-header']/div/div/div[2]/div[4]/div/div/div/div/label/div/div/input")
        ));

        searchField.sendKeys("Selenium");
        searchField.sendKeys(org.openqa.selenium.Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("q=Selenium"));
        assertTrue(driver.getCurrentUrl().contains("Selenium"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        WebElement menuPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-test='main-submenu']")
        ));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.toolsMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        WebElement findToolsLink = wait.until(ExpectedConditions.elementToBeClickable(mainPage.findYourToolsButton));
        findToolsLink.click();

        WebElement productsList = driver.findElement(By.id("products-page"));

        wait.until(ExpectedConditions.titleContains("Developer Tools"));
        assertTrue(driver.getTitle().contains("Developer Tools"));
    }
}
