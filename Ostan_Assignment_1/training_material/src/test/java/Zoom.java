import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Zoom {

    private static AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @iOSXCUITFindBy(accessibility = "Pinch Zoom")
    public static MobileElement zoom;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    @iOSXCUITFindBy(accessibility = "dog")
    public static MobileElement dog;

//    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
//    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
//    @iOSXCUITFindBy(accessibility = "DoubleTap Successful")
//    public static MobileElement toast;

    Zoom(){
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

        new Zoom();

        Thread.sleep(2000);

        TouchAction t = new TouchAction(driver);

        Dimension frame =driver.manage().window().getSize();

        int startx = frame.width/2;
        int starty = (int) (frame.height*(0.50));

        int endx = frame.width/2;
        int endy = (int) (frame.height*(0.70));

        System.out.println("startx: ="+startx);
        System.out.println("starty: ="+starty);
        System.out.println("endx: ="+endx);
        System.out.println("endy: ="+endy);

        t.press(PointOption.point(endx,endy))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(startx,starty)).release().perform();

        Thread.sleep(2000);

        zoom.click();

        Thread.sleep(2000);

//        TouchAction action1 = new TouchAction(driver);

//        TouchAction action1 = new TouchAction(driver)
//        .press(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*0.9)))
//        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//        .moveTo(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*0.8))).release();
//
//        TouchAction action2 = new TouchAction(driver)
//        .press(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*1.1)))
//        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//        .moveTo(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*1.2))).release();

        TouchAction action1 = new TouchAction(driver)
                .press(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*0.8)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*0.85))).release();

        TouchAction action2 = new TouchAction(driver)
                .press(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*1.1)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(dog.getCenter().x, (int) (dog.getCenter().y*1.1))).release();

//       action1.press(PointOption.point(dog.getCenter().x+10,dog.getCenter().y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
//                .moveTo(PointOption.point(dog.getCenter().x+10,dog.getCenter().y+100)).release();
//
//        TouchAction action2 = new TouchAction(driver);
//
//        action2.press(PointOption.point(dog.getCenter().x-10,dog.getCenter().y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
//                .moveTo(PointOption.point(dog.getCenter().x-10,dog.getCenter().y-100)).release();

        MultiTouchAction mutli = new MultiTouchAction(driver);

        mutli.add(action1).add(action2).perform();

        Thread.sleep(2000);

        driver.quit();

    }
}

