import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("wewewe", "wewewe");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Welcome to GitHub!", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
