import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckingElementAvailability {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://serblog.ru/demo/disabled-button/");
        WebElement button1 = driver.findElement(By.xpath("(//button[text()='Кнопка'])[1]"));
        WebElement field1 = driver.findElement(By.xpath("//input[@class='form-control inp']"));
        System.out.println(button1.isEnabled());
        field1.sendKeys("89000000000");
        System.out.println(button1.isEnabled());
        if (button1.isEnabled()) {
            button1.click();
        }

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        selectCheckbox(1);
        selectCheckbox(2);

        driver.get("https://www.ebay.com/");
        WebElement link1 = driver.findElement(By.xpath("//a[text()='Смартфоны и аксессуары']"));
        WebElement link2 = driver.findElement(By.xpath("(//a[text()='Мода'])[2]"));
        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());
        if (link1.isDisplayed()) {
            link1.click();
        } else {
            link2.click();
        }

        driver.quit();
    }

    public static void selectCheckbox(int number) {
        String checkboxXpath = String.format("//form[@id='checkboxes']/input[%s]", number);
        if (!driver.findElement(By.xpath(checkboxXpath)).isSelected()) {
            driver.findElement(By.xpath(checkboxXpath)).click();
            System.out.println("Checkbox " + number + " selected");
        } else {
            System.out.println("Checkbox " + number + " has been selected");
        }
    }
}
