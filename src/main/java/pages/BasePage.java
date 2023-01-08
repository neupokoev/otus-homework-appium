package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage<T> {
    private final String usersMenu = "//android.view.View[contains(@content-desc, \"Пользователи\")]";
    private final String postsMenu = "//android.view.View[contains(@content-desc, \"Посты\")]";

    public UsersPage open() {
        Selenide.open();
        return new UsersPage();
    }

    public UsersPage clickUsersMenuItem() {
        $x(usersMenu).click();
        return new UsersPage();
    }

    public PostsPage clickPostsMenuItem() {
        $x(postsMenu).click();
        return new PostsPage();
    }
}
