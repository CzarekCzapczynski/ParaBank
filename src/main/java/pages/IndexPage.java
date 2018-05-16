package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {
    @FindBy(css="[name='username']")
    private WebElement userNameInput;

    @FindBy(css="[name='password']")
    private WebElement passwordInput;

    @FindBy(css=".login .button")
    private WebElement loginButton;


    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IndexPage openIndexPage() {
        driver.get("http://parabank.parasoft.com");
        this.waitForJStoLoad();
        return this;
    }

    public IndexPage setUserName(String username){
        userNameInput.sendKeys(username);
        return this;
    }

    public IndexPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        this.waitForJStoLoad();
        return new AccountPage(driver);
    }

    public RegisterPage clickRegisterLink() {
        registerLink.click();
        this.waitForJStoLoad();
        return new RegisterPage(driver);
    }
}
