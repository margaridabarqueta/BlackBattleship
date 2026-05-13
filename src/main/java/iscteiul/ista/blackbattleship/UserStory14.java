package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 14 (Portal para Developers).
 * Mapeia o link no rodapé que redireciona para a documentação da API.
 */
public class UserStory14 {

    /**
     * Localizador para o link "Developers".
     * Utiliza XPath para encontrar o link exato que aponta para o subdomínio dos developers.
     */
    @FindBy(xpath = "//a[contains(@href, 'developers.papergames.io')]")
    public WebElement linkDevelopers;

    /**
     * Construtor da classe UserStory14.
     * @param driver O WebDriver instanciado que controla o browser.
     */
    public UserStory14(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}