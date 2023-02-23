package myTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Program1 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void test2(){
        boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        Assert.assertTrue(flag);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
