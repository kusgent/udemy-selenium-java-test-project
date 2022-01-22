package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PerformingComplexActions {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ebay.com/");

        WebElement link = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']/a[text()='Электроника']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();

//        другие методы (не найдено примеров web-страниц):

//        WebElement element = driver.findElement(By.xpath(...));
//
//        actions.dragAndDrop(element, link).build().perform();
//
//        actions.clickAndHold(element).moveToElement(link).release().build().perform();
//        или
//        Action action = actions.clickAndHold(element).moveToElement(link).release().build();
//        action.perform();
//
//        actions.doubleClick(element);
//        actions.contextClick(element);

        driver.quit();
    }
}
