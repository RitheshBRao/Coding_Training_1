import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTest extends TestBase {

@Test
    public void VerifyTheCloseIconInTheLongPressScreen(){

    try{
        Assert.assertTrue(Pages.LongPressPage().VerifyTheCloseIcon());
    }catch(Exception e){
        Assert.fail("VerifyTheCloseIconInTheLongPressScreen is failed");

    }
}
}
