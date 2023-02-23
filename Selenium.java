import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:4200/employees");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/app-root/nav/ul/li[2]/a")).click();
        driver.findElement(By.id("firstName")).sendKeys("Junu");
        driver.findElement(By.id("lastName")).sendKeys("Thapa");
        driver.findElement(By.id("emailId")).sendKeys("junu@gmail.com");
        driver.findElement(By.xpath("/html/body/app-root/div/app-create-employee/div/form/button")).click();
        driver.quit();

    }
}
