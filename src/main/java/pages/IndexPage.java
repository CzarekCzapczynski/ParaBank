package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {
    private String url;
    public LoginAssertion loginAssertion;

    @FindBy(css="[name='username']")
    private WebElement userNameInput;

    @FindBy(css="[name='password']")
    private WebElement passwordInput;

    @FindBy(css=".login .button")
    private WebElement loginButton;

    @FindBy(css = "[href*='lookup.htm']")
    private WebElement forgotLoginInfoLink;


    public IndexPage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.loginAssertion = new LoginAssertion(driver);
        this.url = url;
    }

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.loginAssertion = new LoginAssertion(driver);
    }

    public IndexPage openIndexPage() {
        driver.get(url);
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

    public LookupPage clickForgotLoginInfoLink() {
        forgotLoginInfoLink.click();
        this.waitForJStoLoad();
        return new LookupPage(driver);
    }
}
