package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class PostPage extends BasePage<PostPage> {

    final String postXPath = "//android.view.View[contains(@content-desc, \"post id: %s\")]";
    final String postAndroidUIAutomatorLocator = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
            + ".scrollIntoView(new UiSelector().descriptionContains(\"post id: %s\").instance(0))";
    final String firstPostDescriptionText = "//android.view.View[contains(@content-desc, \"sunt aut facere repellat provident occaecati excepturi optio\")]";

    public PostPage checkPostWithId(int postId) {
        $x(String.format(postXPath, postId)).shouldBe(Condition.visible);
        return this;
    }

}