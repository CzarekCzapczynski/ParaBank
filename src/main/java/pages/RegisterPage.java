package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends MainPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void openRegisterPage() {
        driver.get("http://parabank.parasoft.com/parabank/register.htm");
    }

    public void setFirstName(String firstName){
        driver.findElement(By.cssSelector("[id='customer.firstName']")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.cssSelector("[id='customer.lastName']")).sendKeys(lastName);
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
        driver.findElement(By.cssSelector("[id$='ssn']")).sendKeys(ssn);
    }

    public void setUsername(String username) {
        driver.findElement(By.cssSelector("[id$='username']")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.cssSelector("[id$='password']")).sendKeys(password);
    }

    public void setRepeatedPassword(String repeatedPassword) {
        driver.findElement(By.cssSelector("#repeatedPassword")).sendKeys(repeatedPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(By.cssSelector("[value='Register']")).click();
    }

    public void fillRegisterForm(String firstName, String lastName,
                                 String street, String city, String state, String zipCode,
                                 String ssn,
                                 String username, String password, String repeatedPassword) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setSsn(ssn);
        setUsername(username);
        setPassword(password);
        setRepeatedPassword(repeatedPassword);
    }

    public boolean isErrorDuringExecution(By by) {
        return driver.findElement(by).isDisplayed();
    }
}
