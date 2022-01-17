import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserTabs {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/windows");
        String mainTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        driver.findElement(By.xpath("//a[text()='Sauce Labs']")).click();

        driver.switchTo().window(mainTab);
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        driver.quit();
    }
}
