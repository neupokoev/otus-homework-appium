package pages.accessability;

import com.codeborne.selenide.Condition;
import data.accessability.AccessibilityTextViewData;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class AccessibilityNodeProviderPage extends BasePage<AccessibilityNodeProviderPage> {

  public AccessibilityNodeProviderPage checkViewText(AccessibilityTextViewData textViewData) {
    $(String.format("[text='%s']", textViewData.getName())).shouldBe(Condition.visible);

    return this;
  }

  public AccessibilityNodeProviderPage checkColorView() {
    $("[class='android.view.View']").shouldBe(Condition.visible);

    return this;
  }
}
