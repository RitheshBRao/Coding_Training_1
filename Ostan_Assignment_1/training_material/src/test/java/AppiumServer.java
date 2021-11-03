import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppiumServer {

    private static AppiumDriver driver;

    public static void main(String args[]) throws InterruptedException, MalformedURLException {
        AppiumDriverLocalService service;


            service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                            .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                            .withLogFile(new File("/Users/ostanpritheshdsouza/Documents/logs.txt"))
                            .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
            );

            service.start();
        try {


            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone11");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            cap.setCapability("eventTimings", "true");
//        cap.setCapability(MobileCapabilityType.APP, "/Users/ostanpritheshdsouza/Downloads/Runner_WebView/Runner.ipa");
            cap.setCapability("udid", "DF55EE8C-7749-4C9F-861A-DBBE279BF3C0");
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.codecraft.gestureAutomate");
//        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
//        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");


            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            System.out.println(driver.getSessionDetails());


//        driver.findElementByAccessibilityId("Tap").click();
//
//        Thread.sleep(5000);
//
//        System.out.println(driver.getPageSource());
//
//        System.out.println(driver.findElementByAccessibilityId("switch").isDisplayed());

//        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.HOME));
//
//        ((AndroidDriver)driver).getKeyboard().pressKey("abcd");
//
//        ((AndroidDriver)driver).resetApp();
//
//        ((AndroidDriver)driver).lockDevice(Duration.ofMillis(1000));
//        ((AndroidDriver)driver).unlockDevice();
//
//            ((IOSDriver) driver).activateApp("com.apple.Preferences");
//
//            Thread.sleep(2000);
//
//            ((IOSDriver) driver).activateApp("com.codecraft.gestureAutomate");

            ((IOSDriver) driver).launchApp();

            System.out.println(((HashMap<String,String>)(driver.getSessionDetails().get("events"))).get(""));

            System.out.println(((IOSDriver) driver).queryAppState("com.codecraft.gestureAutomate"));

            driver.quit();
        }
        catch(Exception e) {

            service.stop();
        }
        finally {
            service.stop();
        }

    }
}
