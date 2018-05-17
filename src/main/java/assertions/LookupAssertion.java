package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class LookupAssertion extends MainPage{

    @FindBy(xpath = "//p[contains(.,'Your login information was located successfully.')]")
    private WebElement successfullMessage;

    public LookupAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isLoginLocated() {
        Assert.assertTrue(successfullMessage.isDisplayed());
    }
}
