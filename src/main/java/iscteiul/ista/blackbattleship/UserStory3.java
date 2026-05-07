package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Classe Page Object Model (POM) para o cenário de teste UserStory2 (Aceder aos Guias de Jogo).
 * Esta classe isola os localizadores (locators) e as operações (métodos) exclusivas desta página,
 * separando a lógica da interface da lógica de teste.
 */
public class UserStory3 {
    private WebDriver driver;

    // Localizadores (CSS e XPath) extraídos da exploração e do ficheiro .side
    private By linkGameGuides = By.cssSelector("a[href*='game-guides']");
    private By btnConsent = By.xpath("//*[text()='Consent' or contains(text(), 'Consent')]");

    /**
     * Construtor da classe UserStory2.
     * @param driver Instância do WebDriver utilizada para interagir com o browser.
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navega para a página inicial do jogo Battleship.
     */
    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    /**
     * Lida com o banner de cookies, fechando-o caso esteja presente no ecrã.
     * Utiliza JavascriptExecutor para forçar o clique, contornando sobreposições no DOM.
     */
    public void acceptCookies() {
        try {
            WebElement cookieButton = driver.findElement(btnConsent);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", cookieButton);
        } catch (Exception e) {
            System.out.println("Aviso de cookies não encontrado ou já aceite.");
        }
    }

    /**
     * Clica no link do menu lateral para aceder à secção "Game Guides".
     * Utiliza JavascriptExecutor para garantir o clique mesmo que o elemento exija scroll na janela.
     */
    public void goToGameGuides() {
        WebElement menuGuides = driver.findElement(linkGameGuides);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", menuGuides);
    }
}