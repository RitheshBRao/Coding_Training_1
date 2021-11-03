package CarouselPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CarouserPageObjectRepo extends Object_base {
    public CarouserPageObjectRepo(AppiumDriver driver){super(driver);}

    @iOSXCUITFindBy( accessibility= "Carousel")
    public static WebElement carousleButton;

    @iOSXCUITFindBy( accessibility= "assets/first.jpeg")
    public static WebElement firstImage;

    @iOSXCUITFindBy( accessibility= "assets/second.jpeg")
    public static WebElement secondImage;

    @iOSXCUITFindBy( accessibility= "assets/third.jpeg")
    public static WebElement thirdImage;

    @iOSXCUITFindBy( accessibility= "assets/fourth.jpeg")
    public static WebElement fourthImage;

    @iOSXCUITFindBy( accessibility= "assets/fifth.jpeg")
    public static WebElement fifthImage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Carousel']/preceding-sibling:: XCUIElementTypeButton")
    public static WebElement backButton;

}
