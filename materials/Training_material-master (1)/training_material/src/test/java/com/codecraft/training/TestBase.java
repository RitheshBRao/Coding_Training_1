package com.codecraft.training;

import com.codecraft.training.Utils.PropertyReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static RemoteWebDriver driver;
    public  AppiumDriverLocalService service;

    @BeforeTest
    public void setup() throws IOException {
        startServer();
        if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("ANDROID")) {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        else if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("IOS")) {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        else if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("WEB")) {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        stopServer();
    }

    private static Properties getPropertyValues() throws IOException {
//        FileInputStream property = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/config.properties"));
//        Properties prop = new  Properties();
//        prop.load(property);
//        return prop;
        return PropertyReader.getinstance().readProperty("config.properties");
    }

    private void stopServer() {
        service.stop();
    }

    private void startServer() {
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                        .withLogFile(new File("/Users/ostanpritheshdsouza/Documents/logs.txt"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
        );
        service.start();
    }

    private DesiredCapabilities getCapabilities() throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();

        if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("ANDROID")){
            cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPropertyValues().getProperty("VERSION"));
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, getPropertyValues().getProperty("DEVICE"));
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            cap.setCapability(MobileCapabilityType.APP, getPropertyValues().getProperty("APP"));
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getPropertyValues().getProperty("SETUP"));
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getPropertyValues().getProperty("SETUP"));
        }
        else if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("IOS")) {
            cap.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPropertyValues().getProperty("VERSION"));
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, getPropertyValues().getProperty("DEVICE"));
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            cap.setCapability(MobileCapabilityType.APP, getPropertyValues().getProperty("APP"));
            cap.setCapability("udid", getPropertyValues().getProperty("UDID"));
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getPropertyValues().getProperty("BUNDLE"));
        }
        else if(getPropertyValues().getProperty("SETUP").equalsIgnoreCase("WEB")) {
            cap.setCapability(CapabilityType.PLATFORM_NAME, "iOS");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone11");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            cap.setCapability(MobileCapabilityType.APP, "/Users/ostanpritheshdsouza/Downloads/Runner_WebView/Runner.ipa");
            cap.setCapability("udid", "DF55EE8C-7749-4C9F-861A-DBBE279BF3C0");
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.codecraft.gestureAutomate");
        }
        else
            cap = null;
        return cap;
    }

    @DataProvider(name="input")
    Object[][] getTestData() {
        return new Object[][]{ {"Ostan"},{"Asmit"},{"Suma"},{"Harish"},{"Supreetha"},{"jatindra"},{"parinitha"}};
    }

}
