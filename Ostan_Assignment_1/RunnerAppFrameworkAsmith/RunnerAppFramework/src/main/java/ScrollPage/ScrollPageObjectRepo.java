package ScrollPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ScrollPageObjectRepo extends Object_base {
    public AppiumDriver driver;
    public ScrollPageObjectRepo(AppiumDriver driver){super(driver);}

    @iOSXCUITFindBy(accessibility = "Vertical Swipe")
    public static MobileElement scroll;

//    @iOSXCUITFindBy(xpath = "//android.view.View[contains(@content-desc,\"Gagan\")]")
//   // @AndroidFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label CONTAINS \"Gagan\"`]")
//    public static MobileElement lastelement;

    //XCUIElementTypeOther/XCUIElementTypeOther /XCUIElementTypeStaticText

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther/XCUIElementTypeOther /XCUIElementTypeStaticText)[10]")
    public static WebElement lastelement;
}
