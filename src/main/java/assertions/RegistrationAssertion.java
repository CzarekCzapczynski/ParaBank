package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class RegistrationAssertion extends MainPage{
    @FindBy(xpath = "//p[contains(.,'Your account was created successfully.')]")
    private WebElement userCreated;

    public RegistrationAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserRegister() {
        Assert.assertTrue(userCreated.isDisplayed());
    }

    public void isErrorDisplayed(String errorMessage) {
        String xpathSelector = "//span[contains(.,'" + errorMessage + "')]";
        Assert.assertTrue(driver.findElement(By.xpath(xpathSelector)).isDisplayed());
    }
}
