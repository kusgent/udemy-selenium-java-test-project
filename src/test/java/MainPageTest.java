import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void signUpTest() {
        SignUpPage signUpPage = mainPage.clickSignUp();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Welcome to GitHub!", heading);
    }

    @Test
    public void registerTest() {
        SignUpPage signUpPage = mainPage.register("test@test.com");
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Welcome to GitHub!", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
