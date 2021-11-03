import Utils.Base;
import Utils.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
 public static AppiumDriver driver;

    @BeforeClass
    public static void LaunchingTheApp() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app",  PropertyReader.getPropValues("config.properties").get("APP"));
        cap.setCapability("platformVersion", PropertyReader.getPropValues("config.properties").get("platformVersion"));
        cap.setCapability("platformName", PropertyReader.getPropValues("config.properties").get("platformName"));
        cap.setCapability("deviceName", PropertyReader.getPropValues("config.properties").get("deviceName"));
        cap.setCapability("udid", PropertyReader.getPropValues("config.properties").get("Udid"));



        cap.setCapability("automationName", PropertyReader.getPropValues("config.properties").get("automationName"));

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        System.out.println(driver.getSessionDetails());
        Base.driver=driver;
    }

//    @AfterTest
//    public void closeTheApp(){
//
//        System.out.println("Quiting the app");
//        driver.quit();
//    }

    @AfterTest
    @AfterClass
    public void teardown()
    {
        try {
            System.out.println("Quiting the app");
            driver.closeApp();
            driver.quit();
        }
        catch(Exception e) {
            System.out.println(e);
//            throw new RuntimeException("Driver was already killed");
        }
    }

}
