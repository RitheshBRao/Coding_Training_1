package PinchZoomPage;

import Utils.Base;

public class PinchZoomPage extends Base {
    public PinchZoomObjectRepo pz;

    public PinchZoomPage(){pz = new PinchZoomObjectRepo(driver);}

    public void performPinchZoomInOperation() throws InterruptedException {
        scrollUp(1000);
        pz.pinchZoom.click();
        Thread.sleep(2000);
        PinchZoomIn(pz.dog);


    }
}
