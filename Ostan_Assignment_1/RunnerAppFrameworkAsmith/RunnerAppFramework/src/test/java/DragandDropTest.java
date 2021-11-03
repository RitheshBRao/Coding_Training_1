import org.testng.Assert;
import org.testng.annotations.Test;

public class DragandDropTest extends TestBase {

    @Test
    public  void VerifyTheDragAnDrop(){
        try {
            Assert.assertTrue(Pages.DragandDropPage().dragAndDropIcons());
        }catch (Exception e){
            Assert.fail("DragAndDropTest Failed");
        }
    }
}
