import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scroll {

    private static AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @iOSXCUITFindBy(accessibility = "Vertical Swipe")
    public static MobileElement scroll;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    @iOSXCUITFindBy(accessibility = "Gagan 7845961234")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"Gagan\"`]")
    public static MobileElement lastelement;

//    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
//    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
//    @iOSXCUITFindBy(accessibility = "DoubleTap Successful")
//    public static MobileElement toast;

    Scroll(){
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

        new Scroll();

        Thread.sleep(2000);

        scroll.click();

        Thread.sleep(2000);

//        toggle.click();
        TouchAction t = new TouchAction(driver);

        Dimension frame =driver.manage().window().getSize();

        AndroidDriver



        int startx = frame.width/2;
        int starty = (int) (frame.height*(0.50));

        int endx = frame.width/2;
        int endy = (int) (frame.height*(0.70));

        System.out.println("startx: ="+startx);
        System.out.println("starty: ="+starty);
        System.out.println("endx: ="+endx);
        System.out.println("endy: ="+endy);

        //scrollUp
//        t.press(PointOption.point(startx,starty))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                .moveTo(PointOption.point(endx,endy)).release().perform();

        //scrollDown

        t.press(PointOption.point(endx,endy))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(startx,starty)).release().perform();

        Thread.sleep(2000);

        System.out.println(lastelement.isDisplayed());

        new TouchAction<>(driver).press(PointOption.point(startx,starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx,endy)).release().perform();

        Thread.sleep(5000);

        driver.quit();

    }
}
