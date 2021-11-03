package DoubleTapPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoubleTapObjectRepo extends Object_base {
    public DoubleTapObjectRepo(AppiumDriver driver){ super(driver);}

    @iOSXCUITFindBy(accessibility = "Gestures")
    public static WebElement gestureHeading;

    @iOSXCUITFindBy(accessibility = "DoubleTap")
     public static WebElement doubleTap;

    @iOSXCUITFindBy(accessibility = "Double Tap")
    public static WebElement doubleTapTitle;

    @iOSXCUITFindBy(accessibility = "Double Tap Me")
    public static WebElement doubleTapMeButton;

    @iOSXCUITFindBy(accessibility = "DoubleTap Successful")
    public static WebElement toast;

    @iOSXCUITFindBy(xpath = "//android.view.View[@content-desc=\"DoubleTap Successful\"]")
    public static WebElement toastmsg;

//    @iOSXCUITFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
//    public static WebElement toastmsgs;@AndroidFindBy(xpath = "(//android.widget.Button)[1]")

    @iOSXCUITFindBy(xpath = "(//android.widget.Button)[1]")
    public static WebElement CloseButton;

}
