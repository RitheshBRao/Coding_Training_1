import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Locators {

    private static AppiumDriver driver;

    //Using page object pattern ----1
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.CHAIN)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Tap\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`visible == 0 && label == \"Tap\"`]")
    @FindBy(css = "new UiSelector().descriptionMatches(\"Tap\")")
    public static MobileElement mobElement;

    Locators(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "redmi");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        cap.setCapability(MobileCapabilityType.APP, "/Users/ostanpritheshdsouza/Downloads/Runner_WebView/Runner.ipa");
//        cap.setCapability("udid", "7c3783badba58f48280833f48c8a59065546d7d2");
//        cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.codecraft.gestureAutomate");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");


        //By locator strategy ----2
        By element = MobileBy.AndroidUIAutomator("new UiSelector().descriptionMatches(\"Tap\")");
//        By element1 = MobileBy.AndroidUIAutomator("new UiSelector().descriptionMatches(\"DoubleTap\")");
//        By element2 = MobileBy.AndroidUIAutomator("new UiSelector().descriptionMatches(\"Swipe Left\")");
//        By element3 = MobileBy.AndroidUIAutomator("new UiSelector().descriptionMatches(\"Slider\")");
//
//        By elements = MobileBy.iOSClassChain("new UiSelector().descriptionMatches(\"Tap\")");
//        By elements1 = MobileBy.iOSClassChain("new UiSelector().descriptionMatches(\"DoubleTap\")");
//        By elements2 = MobileBy.iOSClassChain("new UiSelector().descriptionMatches(\"Swipe Left\")");
//        By elements3 = MobileBy.iOSClassChain("new UiSelector().descriptionMatches(\"Slider\")");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        new Locators();

         //direct approaches --Android
        System.out.println( ((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().descriptionMatches(\"Tap\")").isDisplayed());
        System.out.println(((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().descriptionMatches(\"Tap\")").isDisplayed());
        System.out.println(driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionMatches(\"Tap\")")).isDisplayed());

        //direct approach --- iOS
//        System.out.println( ((FindsByIosClassChain)driver).findElementByIosClassChain("**/XCUIElementTypeImage[`visible == 0 && label == \"Tap\"`]").isDisplayed());
//        System.out.println(((IOSDriver)driver).findElementByIosNsPredicate("label == \"Tap\"").isDisplayed());
//        System.out.println(driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeImage[`visible == 0 && label == \"Tap\"`]")).isDisplayed());

//        System.out.println(driver.findElement(element).isDisplayed()); //---1
        System.out.println(mobElement.isDisplayed()); //----2

        Thread.sleep(5000);

        System.out.println(driver.getPageSource());

        System.out.println(mobElement.isDisplayed());

//        driver.findElement(element).isDisplayed();

        driver.quit();

    }
}

