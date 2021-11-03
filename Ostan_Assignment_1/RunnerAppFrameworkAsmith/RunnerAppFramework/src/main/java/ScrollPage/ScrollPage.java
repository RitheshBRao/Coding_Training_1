package ScrollPage;

import Utils.Base;

import java.sql.SQLOutput;
import java.util.List;

public class ScrollPage extends Base {
    public ScrollPageObjectRepo sp;
    public ScrollPage(){
        sp=new ScrollPageObjectRepo(driver);
    }


public  boolean VerifyTheScroll(){
    waitUntilElementIsVisible(sp.scroll);
    sp.scroll.click();
    sleep(2000);
    scrollUp(1000);

//    int totalData = driver.findElementsByXPath("//XCUIElementTypeOther/XCUIElementTypeOther /XCUIElementTypeStaticText").size();
//    System.out.println("Size is: "+totalData);
//    List lastContact = driver.findElementsByXPath("(//XCUIElementTypeOther/XCUIElementTypeOther /XCUIElementTypeStaticText)" +"[" +totalData+"]");
//    System.out.println("Last element" +lastContact);

    if(checkVisibilityOfElement(sp.lastelement)){return  true;}else {return  false;}

    //sp.lastelement.isDisplayed();
    //return true;
}
}
