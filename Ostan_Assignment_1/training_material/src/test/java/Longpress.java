import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Longpress {

    private static AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @iOSXCUITFindBy(accessibility = "Long Press")
    public static MobileElement longpress;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    @iOSXCUITFindBy(accessibility = "image")
    public static MobileElement img;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    @iOSXCUITFindBy(accessibility = "Close")
    public static MobileElement close;

    Longpress(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone11");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        cap.setCapability(MobileCapabilityType.APP, "/Users/ostanpritheshdsouza/Downloads/Runner_WebView/Runner.ipa");
        cap.setCapability("udid", "DF55EE8C-7749-4C9F-861A-DBBE279BF3C0");
        cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.codecraft.gestureAutomate");
//        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
//        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");


        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new Longpress();

        driver.findElement(By.cssSelector("abc"));

        longpress.click();

        Thread.sleep(5000);


        new TouchAction(driver).longPress(PointOption.point(img.getCenter())).release().perform();

        new TouchAction(driver).longPress(PointOption.point(img.getCenter())).release().perform();

        new TouchAction(driver).press(PointOption.point(img.getCenter())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).release().perform();

        new TouchAction(driver).tap(PointOption.point(img.getCenter())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).release().perform();

        System.out.println(close.isDisplayed());

        Thread.sleep(5000);

        driver.quit();

    }
}
