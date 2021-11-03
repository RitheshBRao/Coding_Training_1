import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridApp {

    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4.3");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        cap.setCapability(MobileCapabilityType.APP, "/Users/ostanpritheshdsouza/Documents/gesture/gestureAutomate/build/app/outputs/flutter-apk/app-debug.apk");
        cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.codecraft.gestureAutomate");
        cap.setCapability(MobileCapabilityType.UDID, "7c3783badba58f48280833f48c8a59065546d7d2");


        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        Dimension size = driver.manage().window().getSize();
        TouchAction t = new TouchAction(driver);
        for(int i=0;i<3;i++) {
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }

        driver.findElementByAccessibilityId("Web False").click();

        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();

        for(String contextname: contextNames){
            System.out.println("contextName: = "+contextname);
        }

        for(String contextname: contextNames){
            System.out.println("contextName: = "+contextname);
            if(contextname.contains("WEBVIEW"))
                driver.context(contextname);
        }
        System.out.println(driver.getPageSource());
//        new TouchAction<>(driver).press(PointOption.point())

//        System.out.println(driver.findElementByAccessibilityId("switch").isDisplayed());
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello Appium");
//        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello Appium");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.context("WEBVIEW");

//        MobileElement a = (MobileElement) driver.findElementByAccessibilityId("");
//
//        List<MobileElement> abc = driver.findElementsByAccessibilityId("");
        driver.quit();

    }
}

