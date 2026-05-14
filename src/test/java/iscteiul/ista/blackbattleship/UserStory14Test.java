package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class UserStory14Test {
    UserStory14 us14Page = new UserStory14();

    @Test
    public void testAcederPortalDevelopers() {
        open("https://papergames.io/en/battleship");
        sleep(2000);

        us14Page.linkDevelopers.scrollIntoView(true).click(ClickOptions.usingJavaScript());
        sleep(2000);

        switchTo().window(1);
        webdriver().shouldHave(urlContaining("developers.papergames"));
    }
}