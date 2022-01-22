package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SearchingListElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//span[text()='Бытовая техника']/..")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Стиральные и')]")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//legend[text()='Производитель']/..//span"));
        checkboxes.get(2).click();

        if (checkboxes.size() == 12) {
            System.out.println("It's okay!");
        } else {
            System.out.println("Fail!");
        }

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        driver.quit();
    }
}
