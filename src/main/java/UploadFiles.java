import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFiles {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\kusge\\Downloads\\Screenshot_2.png");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        driver.quit();
    }
}
