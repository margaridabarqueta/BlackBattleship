package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class UserStory10 {
    public SelenideElement abaTorneios = $x("//a[contains(@href, 'tournaments')]");
    public SelenideElement botaoCriarTorneio = $x("//span[contains(.,'Create tournament')]");
}