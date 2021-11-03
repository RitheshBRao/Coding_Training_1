package SliderPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SliderPageObjectRepo extends Object_base {
    public static AppiumDriver driver;

    public SliderPageObjectRepo(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy( accessibility= "Slider")
    public static WebElement sliderButton;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"volume\"]/following-sibling:: XCUIElementTypeOther")
//    public static WebElement controlSlide;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`value == \"0%\"`]")
    public static WebElement controlSlide;

    @iOSXCUITFindBy( accessibility= "Slider")
    public static WebElement sliderScreen;

    @iOSXCUITFindBy(accessibility = "Slider moved Successful")
    public static MobileElement toast;


}
