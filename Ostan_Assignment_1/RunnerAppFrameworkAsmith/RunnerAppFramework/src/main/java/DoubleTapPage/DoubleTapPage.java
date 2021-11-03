package DoubleTapPage;

import Utils.Base;
import io.appium.java_client.AppiumDriver;


public class DoubleTapPage extends Base {

  public  DoubleTapObjectRepo dTap;
  public DoubleTapPage(){
      dTap=new DoubleTapObjectRepo(driver);
  }

public  String VerifyDoubleTapSuccessMessage(){
    waitUntilElementIsVisible(dTap.gestureHeading);
    //System.out.println("Gesture:"+ dTap.gestureHeading);
    dTap.doubleTap.click();

    sleep(2000);

    waitUntilElementIsVisible(dTap.doubleTapMeButton);
    //dTap.doubleTapMeButton.click();

    doubleTap(dTap.doubleTapMeButton);
    waitUntilElementIsVisible(dTap.toastmsg);
    String str= dTap.toastmsg.getAttribute("content-desc");

   //String toastMsg = dTap.toastmsg.getText();
   System.out.println("values="+str);
    //System.out.println("Toast message is:" +toastMsg);
    return str;
    //return toastMsg;
}



    public boolean VerifyCloseScreen(){
        dTap.CloseButton.click();
        dTap.gestureHeading.isDisplayed();
        return true;
    }


}
