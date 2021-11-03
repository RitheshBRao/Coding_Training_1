package com.codecraft.training.landing;

import com.codecraft.training.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;

public class Landing extends Base {

    public AppiumDriver driver;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionMatches(\"Tap\")")
    @iOSXCUITFindBy(accessibility = "Tap")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Tap\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`visible == 1 && label == \"Tap\"`]")
    private static MobileElement tap;

    public Landing(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver = driver;
    }

    public void gotoTap(){
        tap.click();
    }
}
