import org.testng.Assert;
import org.testng.annotations.Test;

public class CarouselPageTest extends TestBase {

    @Test
    public void VerifyTheCarousel(){
        try{
        Assert.assertTrue(Pages.CarouselPage().clickCarrousel());

            Assert.assertTrue(Pages.DoubleTapPage().VerifyCloseScreen());

    }catch (Exception e){
        Assert.fail("VerifyTheCarousel Failed");}
    }
}
