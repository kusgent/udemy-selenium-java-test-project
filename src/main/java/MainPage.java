import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[contains(text(), 'Sign in')]");
    private By signUpButton = By.xpath("(//a[contains(text(), 'Sign up')])[1]");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By signUpFormButton = By.xpath("//button[@type='submit']");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String email) {
        this.typeEmail(email);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}
