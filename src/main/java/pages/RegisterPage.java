package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends MainPage {
    public RegistrationAssertion registrationAssertion;

    @FindBy(css = "[id='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[id='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[id$='street']")
    private WebElement streetInput;

    @FindBy(css = "[id$='city']")
    private WebElement cityInput;

    @FindBy(css = "[id$='state']")
    private WebElement stateInput;

    @FindBy(css = "[id$='zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "[id$='ssn']")
    private WebElement ssnInput;

    @FindBy(css = "[id$='username']")
    private WebElement usernameInput;

    @FindBy(css = "[id$='password']")
    private WebElement passwordInput;

    @FindBy(css = "#repeatedPassword")
    private WebElement repeatedPasswordInput;

    @FindBy(css = "[value='Register']")
    private WebElement registerButton;

    @FindBy(css = "[href*='logout.htm']")
    private WebElement logoutLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        registrationAssertion = new RegistrationAssertion(driver);
    }

//    public RegisterPage openRegisterPage() {
//        openMainPage().clickRegisterLink();
//        return new RegisterPage(driver);
//    }

    public RegisterPage setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage setStreet(String street) {
        streetInput.sendKeys(street);
        return this;
    }

    public RegisterPage setCity(String city) {
       cityInput.sendKeys(city);
       return this;
    }

    public RegisterPage setState(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public RegisterPage setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegisterPage setSsn(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegisterPage setUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage setRepeatedPassword(String repeatedPassword) {
        repeatedPasswordInput.sendKeys(repeatedPassword);
        return this;
    }

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        this.waitForJStoLoad();
        return this;
    }

    public IndexPage logout() {
        logoutLink.click();
        return new IndexPage(driver);
    }
}
