package pages;

import assertions.LookupAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LookupPage extends MainPage{
    public LookupAssertion lookupAssertion;

    @FindBy(css = "#firstName")
    private WebElement firstNameInput;

    @FindBy(css = "#lastName")
    private WebElement lastNameInput;

    @FindBy(css = "[id$='street']")
    private WebElement streetInput;

    @FindBy(css = "[id$='city']")
    private WebElement cityInput;

    @FindBy(css = "[id$='state']")
    private WebElement stateInput;

    @FindBy(css = "[id$='zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "#ssn")
    private WebElement ssnInput;

    @FindBy(css = "[value^='Find']")
    private WebElement findMyLoginInfoButton;

    public LookupPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        lookupAssertion = new LookupAssertion(driver);
    }

    public LookupPage setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public LookupPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public LookupPage setStreet(String street) {
        streetInput.sendKeys(street);
        return this;
    }

    public LookupPage setCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public LookupPage setState(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public LookupPage setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public LookupPage setSsn(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }

    public LookupPage clickFindMyLoginInfoButton() {
        findMyLoginInfoButton.click();
        return this;
    }

    public void fillLookupForm(String firstName, String lastName,
                                 String street, String city, String state, String zipCode, String ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setSsn(ssn);
    }

    public boolean isExecutionPassed(By by) {
        return driver.findElement(by).isDisplayed();
    }
}
