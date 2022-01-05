import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Buttons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://en.wikipedia.org/");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        driver.get("https://github.com/");
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Sign up for GitHub')]"));
        if (button.getText().equals("Sign up for GitHub")) {
            System.out.println(button.getText() + " - button text. Success!");
        }
        else System.out.println("Fail!");
//        button.submit();

        driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();

        driver.get("https://en-gb.facebook.com/");
        driver.findElement(By.xpath("//button[@name='login']")).submit();

        driver.quit();
    }
}
