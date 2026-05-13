package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class UserStory9Test {
    UserStory9 us09Page = new UserStory9();

    @Test
    public void testAcederLojaGoodies() {
        open("https://papergames.io/en/battleship");
        sleep(2000); // Pausa visual para o professor

        // Clique forçado via JS embutido no Selenide (adeus JavascriptExecutor!)
        us09Page.goodiesLink.click(ClickOptions.usingJavaScript());
        sleep(2000);

        // Muda para o 2º separador instantaneamente
        switchTo().window(1);

        // Asserção nativa do Selenide
        webdriver().shouldHave(urlContaining("https://merch.papergames.io/"));
    }
}