package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 10 (Criar Torneio).
 * Mapeia os botões e abas necessários para iniciar a criação de um torneio.
 */
public class UserStory10 {

    /**
     * Localizador para o separador/menu lateral de "Tournaments" (Torneios).
     * Procura um link que contenha a palavra 'tournaments' no URL.
     */
    @FindBy(xpath = "//a[contains(@href, 'tournaments')]")
    public WebElement abaTorneios;

    /**
     * Localizador para o botão "Create tournament" (Criar torneio).
     * Utiliza o texto exato do botão que foi gravado no Selenium IDE.
     */
    @FindBy(xpath = "//span[contains(.,'Create tournament')]")
    public WebElement botaoCriarTorneio;

    /**
     * Construtor da classe UserStory10.
     * Inicializa os elementos mapeados usando o PageFactory.
     * @param driver O WebDriver instanciado que controla o browser.
     */
    public UserStory10(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}