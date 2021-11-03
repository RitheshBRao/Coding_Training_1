package SliderPage;

import Utils.Base;

public class SliderPage extends Base {
    public SliderPageObjectRepo slider;

    public SliderPage(){ slider = new SliderPageObjectRepo(driver);}

    public String slideSeekBarToHundredPercent() throws InterruptedException {

        slider.sliderButton.click();
        Thread.sleep(2000);
        //waitUntilElementIsVisible(slider.sliderScreen);
        //slider.sliderButton.click();
        Slider(slider.controlSlide);
        String toastMsg = slider.toast.getText();

        return toastMsg;


    }


}
