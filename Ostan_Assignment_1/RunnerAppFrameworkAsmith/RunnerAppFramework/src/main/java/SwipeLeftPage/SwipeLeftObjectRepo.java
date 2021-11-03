package SwipeLeftPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SwipeLeftObjectRepo extends Object_base {
    public AppiumDriver driver;
    public SwipeLeftObjectRepo(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "Swipe Left")
    public static WebElement swipe;

    @iOSXCUITFindBy(accessibility = "Chat was deleted Successful")
    public static WebElement toast;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"Lisa\"`]")
    public static MobileElement firstMsg;
}
