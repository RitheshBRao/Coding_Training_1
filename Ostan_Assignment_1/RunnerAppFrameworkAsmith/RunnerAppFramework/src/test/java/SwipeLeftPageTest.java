import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeLeftPageTest extends TestBase{

    @Test
    public void VerifyToastMsgAfterDeletingChat(){

        try{
            String actual = "Chat was deleted Successful";
            System.out.println("Actual Toast Message is: " + actual);
            String expected = Pages.SwipeLeftPage().getToastMessageAfterDeletingChat();
            System.out.println("Expected Toast Message is: " + expected);
            Assert.assertEquals(actual, expected);

        }catch (Exception e){
            Assert.fail("VerifyToastMsgAfterDeletingChat is Failed");
        }
    }
}
