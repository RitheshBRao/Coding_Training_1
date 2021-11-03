package LongPressPage;

import DoubleTapPage.DoubleTapObjectRepo;
import Utils.Base;

public class LongPressPage extends Base {
    public LongPressPageObjectRepo lp;
    public LongPressPage(){
        lp=new LongPressPageObjectRepo(driver);
    }
    public boolean VerifyTheCloseIcon(){
        waitUntilElementIsVisible(lp.longpress);
        System.out.println("Gesture:"+ lp.longpress);
        lp.longpress.click();
        waitUntilElementIsVisible(lp.img);
        lp.img.click();
        LongPress(lp.img);
        lp.close.isDisplayed();
        System.out.println("Close icon should be displayed");
        return true;
   }
}
