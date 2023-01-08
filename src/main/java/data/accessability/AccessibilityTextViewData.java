package data.accessability;

public enum AccessibilityTextViewData {
  NODE_PROVIDER("Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.");

  private String name;

  AccessibilityTextViewData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
