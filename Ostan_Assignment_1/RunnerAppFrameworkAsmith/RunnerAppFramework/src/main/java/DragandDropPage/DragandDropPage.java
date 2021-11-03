package DragandDropPage;

import Utils.Base;

public class DragandDropPage extends Base {
    public DragandDropPageObjectRepo dp;
    public DragandDropPage(){
        dp=new DragandDropPageObjectRepo(driver);
    }
//    public boolean VerifyTheDragnDrop() {
//        scrollUp(500);
//        waitUntilElementIsVisible(dp.Dragndropbutton);
//       dp.Dragndropbutton.click();
//        draganddrop(dp.pythonIcon,dp.python);
//        draganddrop(dp.phpIcon,dp.php);
//        draganddrop(dp.nodeIcon,dp.node);
//        draganddrop(dp.javaIcon,dp.java);
//        draganddrop(dp.reactjsIcon,dp.reactjs);
//       if (dp.reactjs.isDisplayed()) {
//           System.out.println("All Elements should be drag and dropped successfully");
//           return true;
//       }
//       else{
//           return false;
//       }
//    }

    public  boolean dragAndDropIcons() {
        //carrousel = new CarrouselObjectRepository(Carrousel.driver);
        scrollUp(1000);
        dp.dragAndDropButton.click();
//
        waitUntilElementIsVisible(dp.dragAndDropBTitle);
        dragAndDrop(dp.phpIcon, dp.phpButton);
        //System.out.println("Testing" + carrousel.phpIcon.isDisplayed());
        //Assert.assertTrue(checkVisibilityOfElement(carrousel.phpIcon));


        waitUntilElementIsVisible(dp.pythonIcon);
        dragAndDrop(dp.pythonIcon, dp.pythonButton);
        //Assert.assertTrue(checkVisibilityOfElement(carrousel.pythonIcon));


        waitUntilElementIsVisible(dp.nodeIcon);
        dragAndDrop(dp.nodeIcon, dp.nodeButton);
        //Assert.assertTrue(checkVisibilityOfElement(carrousel.nodeIcon));

        waitUntilElementIsVisible(dp.javaIcon);
        dragAndDrop(dp.javaIcon, dp.javaButton);
        //Assert.assertTrue(checkVisibilityOfElement(carrousel.javaIcon));

        waitUntilElementIsVisible(dp.reactIcon);
        dragAndDrop(dp.reactIcon, dp.reactButton);
        //Assert.assertTrue(checkVisibilityOfElement(carrousel.reactIcon));

        if(checkVisibilityOfElement(dp.reactIcon)){
            return true;
        }else{return  false;}



    }

}
