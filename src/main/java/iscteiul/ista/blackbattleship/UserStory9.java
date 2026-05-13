package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 09 (Loja de Merchandising / Goodies).
 * Mapeia os elementos da página Web necessários para executar o teste,
 * isolando a estrutura do HTML da lógica de teste.
 */
public class UserStory9 {

    /**
     * Localizador para o botão/link "Goodies".
     * Utiliza XPath para encontrar o elemento span que contém o texto exato.
     */
    @FindBy(xpath = "//span[contains(.,'Goodies')]")
    public WebElement goodiesLink;

    /**
     * Construtor da classe UserStory09.
     * Inicializa os elementos da página Web mapeados usando o PageFactory.
     * * @param driver O WebDriver instanciado que controla o browser.
     */
    public UserStory9(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
