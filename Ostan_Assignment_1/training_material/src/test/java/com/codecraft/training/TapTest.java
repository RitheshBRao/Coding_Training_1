package com.codecraft.training;

import com.codecraft.training.landing.Landing;
import com.codecraft.training.tap.Tap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TapTest extends TestBase{

    public Tap tap;
    public Landing landing;

    @BeforeClass
    public void init(){
        landing = new Landing((AppiumDriver)driver);
        tap= new Tap((AppiumDriver)driver);
    }

    @Test(dataProvider = "input",dataProviderClass=TestBase.class)
    public void tapTestcase(String names){
        System.out.println("name : ="+names);

        landing.gotoTap();

        Assert.assertTrue(tap.tapAction());

    }

}
