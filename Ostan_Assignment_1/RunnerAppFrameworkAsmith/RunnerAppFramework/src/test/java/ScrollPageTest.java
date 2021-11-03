import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollPageTest extends TestBase {
    @Test
    public void VerifyTheScroll(){
        Assert.assertTrue(Pages.ScrollPage().VerifyTheScroll());
    }
}
