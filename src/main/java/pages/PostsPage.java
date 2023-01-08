package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class PostsPage extends BasePage<PostsPage> {

    final String postsXPath = "//android.widget.ScrollView/android.view.View";
    final String postXPath = "//android.view.View[contains(@content-desc, \"post id: %s\")]";
    final String postAndroidUIAutomatorLocator = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
            + ".scrollIntoView(new UiSelector().descriptionContains(\"post id: %s\").instance(0))";
    final String firstPostDescriptionText = "//android.view.View[contains(@content-desc, " +
            "\"sunt aut facere repellat provident occaecati excepturi optio\")]";

    public PostsPage checkAmountOfPostCards(int postId) {
        scrollToPostWithId(postId);
        return this;
    }

    public PostsPage checkSomeTextsOnPostCards() {
        $x(firstPostDescriptionText).shouldBe(Condition.visible);
        return this;
    }

    public PostPage choosePostWithId(int postId) {
        scrollToPostWithId(postId);
        $x(String.format(postXPath, postId)).click();
        return new PostPage();
    }

    private PostsPage scrollToPostWithId(int postId) {
        try {
            webdriver().driver().getWebDriver()
                    .findElement(MobileBy.AndroidUIAutomator(String.format(postAndroidUIAutomatorLocator, postId)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}