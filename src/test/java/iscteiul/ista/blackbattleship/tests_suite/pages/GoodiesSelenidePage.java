package iscteiul.ista.blackbattleship.tests_suite.pages;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GoodiesSelenidePage {

    public SelenideElement goodiesLink = $("a[href*='merch']");

    public void openPage() {
        open("https://papergames.io/en/battleship");
    }

    public void openGoodiesStore() {
        goodiesLink.click(ClickOptions.usingJavaScript());
    }
}