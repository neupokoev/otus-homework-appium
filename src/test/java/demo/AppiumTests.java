package demo;

import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.UsersPage;

@ExtendWith(AppiumExtension.class)
public class AppiumTests {

    private final UsersPage usersPage = new UsersPage();

    @Test
    public void uiPostsPageTest() {
        usersPage
                .open()
                .clickPostsMenuItem()
                .checkSomeTextsOnPostCards()
                .checkAmountOfPostCards(100);
    }

    @Test
    public void uiPostIdOpenTest() {
        int postIdUnderTest = 1;
        usersPage
                .open()
                .clickPostsMenuItem()
                .choosePostWithId(postIdUnderTest)
                .checkPostWithId(postIdUnderTest);
    }

    @Test
    public void uiUsersOpenTest() {
        String userNameUnderTest = "Antonette";
        usersPage
                .open()
                .chooseUserWithName(userNameUnderTest)
                .checkUserWithName(userNameUnderTest);
    }

}
