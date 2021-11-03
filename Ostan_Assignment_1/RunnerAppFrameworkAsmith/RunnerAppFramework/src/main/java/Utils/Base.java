package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Base {

    public static long wait=90;
    public static AppiumDriver  driver;



    public void tapGesture(WebElement element) {
       TouchAction t=new TouchAction(driver);
                t.tap(TapOptions.tapOptions().withPosition(PointOption.point(element.getLocation().x + element.getSize().width / 2, element.getLocation().y))
                        .withTapsCount(2)).perform();

    }

    public void doubleTap(WebElement element){
        TouchAction t=new TouchAction(driver);
        t.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(element))
                .withTapsCount(2))
                .perform();
    }

    public void LongPress(MobileElement img){
        new TouchAction(driver).longPress(PointOption.point(img.getCenter())).release().perform();

    }

        public static boolean isElementVisible(WebElement element){
            try{
                return element.isDisplayed();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("exception occured");
                return false;
            }

        }
    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilElementIsVisible(WebElement element){
        try{
            WebDriverWait wwait = new WebDriverWait(driver, wait);
            wwait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e)
        {
            System.out.println("exception occured");
        }
    }

    public static void scrollUp(int stepSize) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.5);
        int starty = (int) (size.height * 0.90);
        int endy = (int) (size.height * (0.40));
        TouchAction ta=new TouchAction(driver);
        ta.press(PointOption.point(startx,starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(stepSize)))
                .moveTo(PointOption.point(startx,endy))
                .release()
                .perform();
    }

    public static void draganddrop(WebElement element1, WebElement element2){
        TouchAction ta=new TouchAction(driver);
                        ta.longPress(ElementOption.element(element1))
                        .moveTo(ElementOption.element(element2))
                        .release()
                        .perform();
    }

    public static void Swipe(WebElement ele){
        int starty=  ele.getSize().getHeight();
        int startx= (int) (ele.getSize().getWidth()*0.9);
        int endx= (int) (ele.getSize().getWidth()*0.1);
        TouchAction ta=new TouchAction(driver);
        ta.press(PointOption.point(startx,starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endx,starty))
                .release()
                .perform();
    }

    public static void swipeLeft(WebElement element) {

        int y = element.getSize().getHeight();
        int startX = (int) (element.getSize().getWidth() * 0.9);
        int endX = (int) (element.getSize().getWidth() * 0.1);

        new TouchAction(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, y))
                .release().perform();


    }


    public static void dragAndDrop(WebElement element1, WebElement element2) {
        TouchAction action = new TouchAction(driver);
        action.longPress(ElementOption.element(element1))
                .moveTo(ElementOption.element(element2))
                .release()
                .perform();
    }

    public static boolean checkVisibilityOfElement(WebElement element) {
        try {
            if (element.isDisplayed())
                return false;
            return true;
        } catch (Exception e) {
            System.out.println("Element is not visible and Test case passed");
            return true;
        }


    }

    public void Slider(WebElement seekBar){
        System.out.println("Inside slider method");
//        int startX = seekBar.getLocation().getX();
//        int endX = seekBar.getSize().getWidth()*1+10;
//        int yAxis = seekBar.getLocation().getY();
        TouchAction act=new TouchAction(driver);
//        act.press(PointOption.point(startX,yAxis))
//                .moveTo(PointOption.point(endX,yAxis))
//                .release()
//                .perform();

        act.press(PointOption.point((int) (seekBar.getLocation().x +30), (seekBar.getLocation().y + seekBar.getSize().height/2)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(seekBar.getSize().width/2,(seekBar.getLocation().y+seekBar.getSize().height/2)))
                .release()
                .perform();

//        act.tap(PointOption.point(seekBar.getSize().width/2,seekBar.getLocation().y+seekBar.getSize().height/2)).perform();

    }

    public void SwipeLeftAgain(MobileElement element){

        TouchAction t = new TouchAction(driver);

        Dimension frame =driver.manage().window().getSize();



        int startx = (int) ((element.getSize().width)*0.90);
        int starty =  element.getCenter().y;

        int endx = (int) ((element.getSize().width)*0.20);
        int endy = element.getCenter().y;


        //swipeLeft

        t.tap(TapOptions.tapOptions()).press(PointOption.point(startx,starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endx,endy)).release().perform();


    }

    public void PinchZoomIn(MobileElement element){

        TouchAction action1 = new TouchAction(driver)
                .press(PointOption.point(element.getCenter().x, (int) (element.getCenter().y*0.8)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(element.getCenter().x, (int) (element.getCenter().y*0.85))).release();

        TouchAction action2 = new TouchAction(driver)
                .press(PointOption.point(element.getCenter().x, (int) (element.getCenter().y*1.1)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .moveTo(PointOption.point(element.getCenter().x, (int) (element.getCenter().y*1.1))).release();

        MultiTouchAction mutli = new MultiTouchAction(driver);

        mutli.add(action1).add(action2).perform();



    }




    }

