package DragandDropPage;

import Utils.Object_base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DragandDropPageObjectRepo extends Object_base {

    public DragandDropPageObjectRepo(AppiumDriver driver){super(driver);}

    @iOSXCUITFindBy( accessibility= "Drag n Drop")
    public static WebElement dragAndDropButton;

    @iOSXCUITFindBy( accessibility= "Drag n Drop")
    public static WebElement dragAndDropBTitle;

    @iOSXCUITFindBy( accessibility= "iphp")
    public static WebElement phpIcon;

    @iOSXCUITFindBy( accessibility= "php")
    public static WebElement phpButton;

    @iOSXCUITFindBy( accessibility= "ipython")
    public static WebElement pythonIcon;

    @iOSXCUITFindBy( accessibility= "python")
    public static WebElement pythonButton;

    @iOSXCUITFindBy( accessibility= "inode")
    public static WebElement nodeIcon;

    @iOSXCUITFindBy( accessibility= "node")
    public static WebElement nodeButton;

    @iOSXCUITFindBy( accessibility= "iJava")
    public static WebElement javaIcon;

    @iOSXCUITFindBy( accessibility= "Java")
    public static WebElement javaButton;

    @iOSXCUITFindBy( accessibility= "ireactjs")
    public static WebElement reactIcon;

    @iOSXCUITFindBy( accessibility= "reactjs")
    public static WebElement reactButton;


}
