package LongPressPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LongPressPageObjectRepo extends Object_base {
  public static AppiumDriver driver;
  public LongPressPageObjectRepo(AppiumDriver driver){ super(driver);}

    @iOSXCUITFindBy(accessibility = "Gestures")
    public static WebElement gestureHeading;

    @iOSXCUITFindBy(accessibility = "Long Press")
    public static WebElement longpress;

    @iOSXCUITFindBy(accessibility = "image")
    public static MobileElement img;

    @iOSXCUITFindBy(accessibility = "Close")
    public static WebElement close;

}
