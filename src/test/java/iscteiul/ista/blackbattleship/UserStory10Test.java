package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class UserStory10Test {
    UserStory10 us10Page = new UserStory10();

    @Test
    public void testAcederCriacaoTorneio() {
        open("https://papergames.io/en/battleship");
        sleep(2000);

        us10Page.abaTorneios.click(ClickOptions.usingJavaScript());
        sleep(2000);
        us10Page.botaoCriarTorneio.click(ClickOptions.usingJavaScript());

        webdriver().shouldHave(urlContaining("create"));
    }
}