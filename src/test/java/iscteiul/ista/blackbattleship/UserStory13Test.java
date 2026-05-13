package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class UserStory13Test {
    UserStory13 us13Page = new UserStory13();

    @Test
    public void testAcederGooglePlay() {
        open("https://papergames.io/en/battleship");
        sleep(2000);

        // Faz scroll diretamente no elemento e clica!
        us13Page.botaoGooglePlay.scrollIntoView(true).click(ClickOptions.usingJavaScript());
        sleep(2000);

        switchTo().window(1);
        webdriver().shouldHave(urlContaining("play.google"));
    }
}