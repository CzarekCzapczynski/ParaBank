package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

public class OpenAccountAssertion extends MainPage{
    @FindBy(css="#newAccountId")
    private WebElement newAccountId;

    public OpenAccountAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void isNewAccountAdded() {
        Assert.assertTrue(newAccountId.isDisplayed());
    }

    public void isNewAccountNotAdded(){
        Assert.assertFalse(newAccountId.isDisplayed());
    }
}
