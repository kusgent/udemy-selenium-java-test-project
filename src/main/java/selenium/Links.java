package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Links {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://en.wikipedia.org/");
        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();

        driver.get("https://github.com/");
        driver.findElement(By.xpath("//a[contains(@class, 'HeaderMenu-link') and text()='Team']")).click();

        driver.get("https://en-gb.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();

        driver.quit();
    }
}
