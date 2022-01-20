import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SimulatePressKeys {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://en.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "test test test"));
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
