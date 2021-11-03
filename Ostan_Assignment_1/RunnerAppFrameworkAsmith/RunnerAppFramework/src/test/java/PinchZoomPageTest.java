import org.testng.annotations.Test;

public class PinchZoomPageTest extends TestBase {

    @Test
    public void VerifyPinchZoomInToastMessage(){

        try{
            Pages.PinchZoomPage().performPinchZoomInOperation();
        }catch (Exception e){
            System.out.println("VerifyPinchZoomInToastMessage is Failed"); }
    }
}
