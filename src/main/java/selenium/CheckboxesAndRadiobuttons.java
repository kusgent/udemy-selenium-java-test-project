package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckboxesAndRadiobuttons {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//span[text()='Бытовая техника']/..")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Стиральные и')]")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        selectCheckbox("ATLANT");
        selectCheckbox("Candy");
        selectCheckbox("LG");

        deselectCheckbox("Candy");

        System.out.println();

        System.out.println(driver.findElement(By.xpath("//input[@id='offer-shipping_pickup']")).isSelected());
        driver.findElement(By.xpath("//span[text()='Самовывоз']/..")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='offer-shipping_pickup']")).isSelected());
        driver.findElement(By.xpath("//span[text()='До 5 дней']/..")).click();

        driver.quit();
    }

    public static void selectCheckbox(String name) {
        String checkboxXpath = "//span[text()='%s']";
        if (!driver.findElement(By.xpath(String.format(checkboxXpath, name) + "/parent::*/preceding-sibling::input")).isSelected())
            driver.findElement(By.xpath(String.format(checkboxXpath, name))).click();
    }

    public static void deselectCheckbox(String name) {
        String checkboxXpath = "//span[text()='%s']";
        if (driver.findElement(By.xpath(String.format(checkboxXpath, name) + "/parent::*/preceding-sibling::input")).isSelected())
            driver.findElement(By.xpath(String.format(checkboxXpath, name))).click();
    }

}
