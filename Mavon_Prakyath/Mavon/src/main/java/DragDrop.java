import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragDrop
{
    private static AppiumDriver driver;


    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Drag n Drop\")")
    @AndroidFindBy(accessibility = "Drag n Drop")
    public static MobileElement drag;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "iJava")
    public static MobileElement iJava;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Java")
    public static MobileElement Java;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "inode")
    public static MobileElement inode;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "node")
    public static MobileElement node;


    DragDrop()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    static void Scroll()
    {
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
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(startx,starty)).release().perform();
    }

    static void Drop(MobileElement ele,MobileElement ele1)
    {
        new TouchAction(driver).longPress(PointOption.point(ele.getCenter()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(ele1.getCenter())).release().perform();

    }

    public static void main(String args[]) throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Prakhyath Shetty\\Appium\\app-release.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new DragDrop();

        Thread.sleep(2000);

        Scroll();
        Thread.sleep(2000);
        Scroll();

        Thread.sleep(2000);

        drag.click();

        Thread.sleep(2000);

        Drop(iJava,Java);
        Thread.sleep(5000);
        Drop(inode,node);

        Thread.sleep(5000);
        driver.quit();

    }
}