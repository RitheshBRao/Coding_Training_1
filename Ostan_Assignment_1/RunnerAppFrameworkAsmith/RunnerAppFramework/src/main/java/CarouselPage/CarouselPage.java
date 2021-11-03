package CarouselPage;

import Utils.Base;

public class CarouselPage extends Base {
    public static CarouserPageObjectRepo carrousel;
   // public CarouserPageObjectRepo cr;
//    public CarouselPage(){
//        cr=new CarouserPageObjectRepo(driver);
//    }
//public boolean VerifyCarousel(){
//        scrollUp(500);
//        waitUntilElementIsVisible(cr.carouselButton);
//        cr.carouselButton.click();
//        Swipe(cr.img);
//        return  true;
//    }

    public static boolean clickCarrousel() {
        //carrousel = new CarrouselObjectRepository(Carrousel.driver);

        scrollUp(500);
        waitUntilElementIsVisible(carrousel.carousleButton);
        carrousel.carousleButton.click();
        waitUntilElementIsVisible(carrousel.firstImage);
        swipeLeft(carrousel.firstImage);
        swipeLeft(carrousel.secondImage);
        swipeLeft(carrousel.thirdImage);
        swipeLeft(carrousel.fourthImage);
        //swipeLeft(CarrouselObjectRepository.fifthImage);
        carrousel.backButton.click();
        if(carrousel.fourthImage.isDisplayed()){
            return true;
        }else {return false;}




    }
}
