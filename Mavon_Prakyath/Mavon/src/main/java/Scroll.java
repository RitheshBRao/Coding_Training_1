import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scroll
{

    private static AppiumDriver driver;

    Scroll()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void scrollUp(int stepSize)
    {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int startPoint = (int) (size.height * 0.90);
        int endPoint = (int) (size.height * (0.40));
        new TouchAction(driver)
                .press(PointOption.point(x, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(stepSize)))
                .moveTo(PointOption.point(x, endPoint))
                .release().perform();
    }

    public static void scrollDown(int stepSize)
    {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * 0.5);
        int startPoint = (int) (size.height * 0.40);
        int endPoint = (int) (size.height * (0.90));
        new TouchAction(driver)
                .press(PointOption.point(x, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(stepSize)))
                .moveTo(PointOption.point(x, endPoint))
                .release().perform();
    }

        public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.APP, "D:\\Prakhyath Shetty\\Appium\\app-release.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.gesture_automate");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.gesture_automate.MainActivity");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(10000);
        scrollUp(1000);
        Thread.sleep(10000);
        scrollDown(1000);
        Thread.sleep(10000);
        driver.quit();
    }
}
