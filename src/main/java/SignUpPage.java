import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//span[contains(text(), 'Welcome to GitHub!')]");

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }
}
