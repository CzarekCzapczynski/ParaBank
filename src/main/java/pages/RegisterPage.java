package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends MainPage {
    @FindBy(css = "[id='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[id='customer.firstName']")
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

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage openRegisterPage() {
        driver.get("http://parabank.parasoft.com/parabank/register.htm");
        this.waitForJStoLoad();
        return this;
    }

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
        streetInput.sendKeys(state);
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


    public boolean isErrorDuringExecution(By by) {
        return driver.findElement(by).isDisplayed();
    }
}
