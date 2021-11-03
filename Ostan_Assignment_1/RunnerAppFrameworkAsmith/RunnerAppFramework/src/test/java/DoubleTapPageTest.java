import Utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DoubleTapPageTest extends TestBase {

    @Test
    public void VerifyTheDoubleTapSuccessMessage() {
        try {
            String Actual = "DoubleTap Successful";
            System.out.println("Actual is: " + Actual);
            String Expected = Pages.DoubleTapPage().VerifyDoubleTapSuccessMessage();
            System.out.println("Expected is: " + Expected);
            Assert.assertEquals(Actual, Expected);

            Assert.assertTrue(Pages.DoubleTapPage().VerifyCloseScreen());
        } catch (Exception e) {

            Assert.fail("VerifyTheDoubleTapSuccessMessage is Failed");
        }

    }

}
