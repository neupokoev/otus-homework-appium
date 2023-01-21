package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class SelenideWebDriver implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    //File app = downloadApk();

    UiAutomator2Options options = new UiAutomator2Options();
    options.merge(capabilities);
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setPlatformName("Android");
    options.setDeviceName("otus");
    options.setPlatformVersion("12");

    //options.setApp(app.getAbsolutePath());
    options.setApp("/Volumes/Sea/OTUS/appium-otus/src/test/resources/app_java_pro_v2.apk");

    try {
      return new AndroidDriver(new URL("http://127.0.0.1:5566/wd/hub"), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  private File downloadApk() {
    File apk = new File("build/app_java_pro_v2.apk");
    if (!apk.exists()) {
      String url = "https://github.com/src/test/resources/app_java_pro_v2.apk?raw=true";
      try (InputStream in = new URL(url).openStream()) {
        copyInputStreamToFile(in, apk);
      }
      catch (IOException e) {
        throw new AssertionError("Failed to download apk", e);
      }
    }
    return apk;
  }
}
