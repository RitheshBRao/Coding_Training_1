import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstProgram
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","D://Prakhyath Shetty//Automation Activity//Driver//chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS); // checks the condition always
        //Thread.sleep(5000); // without checking any conditions , add exception as well
        //driver.findElement(By.xpath("//input[@id='services']"));
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.close();
    }
}
