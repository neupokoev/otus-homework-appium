package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class UserPage extends BasePage<UserPage> {

    final String userXPath = "//android.view.View[contains(@content-desc, \"%s\")]";

    public UserPage checkUserWithName(String userName) {
        $x(String.format(userXPath, userName)).shouldBe(Condition.visible);
        return this;
    }

}