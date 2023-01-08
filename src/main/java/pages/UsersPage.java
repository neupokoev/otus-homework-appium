package pages;

import static com.codeborne.selenide.Selenide.$x;

public class UsersPage extends BasePage<UsersPage> {

    final String userXPath = "//android.view.View[contains(@content-desc, \"%s\")]";

    public UserPage chooseUserWithName(String userName) {
        $x(String.format(userXPath, userName)).click();
        return new UserPage();
    }

}
