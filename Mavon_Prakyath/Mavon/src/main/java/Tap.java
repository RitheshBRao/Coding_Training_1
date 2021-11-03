import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Tap
{
    private static AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @AndroidFindBy(accessibility = "Tap")
    public static MobileElement tap;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    public static MobileElement toggle;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"switch\")")
    public static MobileElement toast;

    Tap()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Prakhyath Shetty\\Appium\\app-release.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new Tap();

        tap.click();

        Thread.sleep(5000);

        TouchAction t = new TouchAction(driver);
        System.out.println("location: = "+toggle.getLocation());
        System.out.println("size: = "+toggle.getSize());
        System.out.println("Rect dimentions: = "+toggle.getRect().getDimension());
        System.out.println("Rect: = "+toggle.getRect().getPoint());
        System.out.println("co-ordinates: = "+toggle.getCoordinates());
        System.out.println("center: = "+toggle.getCenter());
        System.out.println("center: = "+toggle.getCenter());
        System.out.println("locator: = "+(toggle.getLocation().x+toggle.getSize().width/2));
        System.out.println("locator: = "+(toggle.getLocation().y+toggle.getSize().height/2));
        t.tap(PointOption.point(toggle.getLocation().x+toggle.getSize().width/2,toggle.getLocation().y+toggle.getSize().height/2)).perform();

        t.tap(TapOptions.tapOptions().withPosition(PointOption.point(toggle.getCenter().x+toggle.getSize().width/2,toggle.getCenter().y)).withTapsCount(2)).perform();

        System.out.println(toast.isDisplayed());

        Thread.sleep(5000);
        
        driver.quit();

    }
}
