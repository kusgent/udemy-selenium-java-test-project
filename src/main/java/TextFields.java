import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TextFields {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://en.wikipedia.org/");
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();

        driver.get("https://github.com/");
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign up for GitHub')]")).submit();

        driver.get("https://en-gb.facebook.com/");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("test@test.com");
        System.out.println(email.getAttribute("value"));
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345q");
        driver.findElement(By.xpath("//button[@name='login']")).submit();

        driver.quit();
    }
}
