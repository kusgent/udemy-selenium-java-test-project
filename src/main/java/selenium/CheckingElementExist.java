package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckingElementExist {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://github.com/");

        if (driver.findElements(By.xpath("//a[contains(text(), 'Log in')]")).size() > 0) {
            System.out.println("Such element is presented");
        } else {
            System.out.println("Cannot find such element");
        }

        driver.quit();
    }
}
