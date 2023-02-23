import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    ChromeDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("http://localhost:4200/employees");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "AngularFrontend";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
