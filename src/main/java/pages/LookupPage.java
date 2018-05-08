package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LookupPage extends MainPage{
    public LookupPage(WebDriver driver) {
        super(driver);
    }

    public void openLookupPage() {
        driver.get("http://parabank.parasoft.com/parabank/lookup.htm");
    }

    public void setFirstName(String firstName){
        driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
    }

    public void setStreet(String street) {
        driver.findElement(By.cssSelector("[id$='street']")).sendKeys(street);
    }

    public void setCity(String city) {
        driver.findElement(By.cssSelector("[id$='city']")).sendKeys(city);
    }

    public void setState(String state) {
        driver.findElement(By.cssSelector("[id$='state']")).sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(By.cssSelector("[id$='zipCode']")).sendKeys(zipCode);
    }

    public void setSsn(String ssn) {
        driver.findElement(By.cssSelector("#ssn")).sendKeys(ssn);
    }

    public void clickFindMyLoginInfoButton() {
        driver.findElement(By.cssSelector("[value^='Find']")).click();
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
