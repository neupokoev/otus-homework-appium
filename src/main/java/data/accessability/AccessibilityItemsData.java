package data.accessability;

import data.MainMenuItemsData;

public enum AccessibilityItemsData implements ISubmenuItems {
  NODE_PROVIDER("Accessibility Node Provider", MainMenuItemsData.ACCESSIBILITY),
  NODE_USERS("Пользователи Tab 1 of 2", MainMenuItemsData.ACCESSIBILITY),
  NODE_POSTS("Посты Tab 2 of 2", MainMenuItemsData.ACCESSIBILITY);

  private String name;
  private MainMenuItemsData mainMenuItemsData;

  AccessibilityItemsData(String name, MainMenuItemsData mainMenuItemsData) {
    this.name = name;
    this.mainMenuItemsData = mainMenuItemsData;
  }

  public String getName() {
    return this.name;
  }

  public MainMenuItemsData getMainMenuItemsData() {
    return mainMenuItemsData;
  }

}
