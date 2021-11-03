import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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

public class Carousel
{
    private static AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Carousel")
    public static MobileElement carousel;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"assets/first.jpeg\")")
    @AndroidFindBy(accessibility = "assets/first.jpeg")
    public static MobileElement Element1;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"assets/second.jpeg\")")
    @AndroidFindBy(accessibility = "assets/second.jpeg")
    public static MobileElement Element2;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"assets/third.jpeg\")")
    @AndroidFindBy(accessibility = "assets/third.jpeg")

    public static MobileElement Element3;
    static void Swipe(MobileElement ele)
    {
        int startx1 = (int) ((ele.getSize().width)* 0.5);
        int starty1 = ele.getSize().height;

        int endx1 = (int) ((ele.getSize().width) * 0.20);
        int endy1 = ele.getCenter().y;


        new TouchAction(driver) .press(PointOption.point(endx1,endy1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startx1,startx1)).release().perform();

    }

    Carousel ()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Prakhyath Shetty\\Appium\\app-release.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new  Carousel ();

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
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(startx,starty)).release().perform();

        Thread.sleep(2000);

        carousel.click();

        Swipe(Element1);
        Swipe(Element2);


        TouchAction t2 = new TouchAction(driver);

        Dimension frame2 =driver.manage().window().getSize();
        int startx2 = (int) ((Element2.getSize().width)* 0.50);
        int starty2 = Element2.getSize().height;

        int endx2 = (int) ((Element2.getSize().width) * 0.20);
        int endy2 = Element2.getCenter().y;
        Thread.sleep(2000);

        t.press(PointOption.point(startx2,starty2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx2,endy2)).release().perform();

        t.press(PointOption.point(endx2,endy2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startx2,starty2)).release().perform();

        Thread.sleep(5000);

        driver.quit();

    }
}

