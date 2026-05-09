package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 13 (App Mobile).
 * Mapeia o botão de download da aplicação na Google Play Store.
 */
public class UserStory13 {

    /**
     * Localizador para o botão "Get it on Playstore".
     * Utiliza o XPath baseado no atributo 'alt' da imagem, tal como gravado no Selenium IDE.
     */
    @FindBy(xpath = "//img[@alt='Get it on Playstore']")
    public WebElement botaoGooglePlay;

    /**
     * Construtor da classe UserStory13.
     * @param driver O WebDriver instanciado que controla o browser.
     */
    public UserStory13(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}