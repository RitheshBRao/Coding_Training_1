package PinchZoomPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PinchZoomObjectRepo extends Object_base {
    public PinchZoomObjectRepo(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Pinch Zoom")
    public static WebElement pinchZoom;

    @iOSXCUITFindBy(accessibility = "dog")
    public static MobileElement dog;

    @iOSXCUITFindBy(accessibility = "Zoom in was Successful")
    public static WebElement toast;

    @iOSXCUITFindBy(accessibility = "Zoom out was Successful")
    public static WebElement toastmsg;
}
