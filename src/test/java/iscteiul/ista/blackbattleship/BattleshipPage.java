package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BattleshipPage {
    private WebDriver driver;

    // Localizadores (Podem precisar de ajuste com o Inspect Element)
    // US01
    private By btnPlayBot = By.xpath("//a[contains(., 'robot')] | //button[contains(., 'robot')] | //*[contains(text(), 'Play vs robot')]");
    private By inputNickname = By.cssSelector("input[type='text']");
    private By btnConfirmNickname = By.xpath("//button[contains(text(), 'Continue')]");
    //US03

    public BattleshipPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    //US01

    public void clickPlayBot() {
        driver.findElement(btnPlayBot).click();
    }

    public void enterNickname(String name) {
        driver.findElement(inputNickname).clear();
        driver.findElement(inputNickname).sendKeys(name);
        driver.findElement(btnConfirmNickname).click();
    }

    //US03



}