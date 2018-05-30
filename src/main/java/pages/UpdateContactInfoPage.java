package pages;

import assertions.UpdateContactInfoAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class UpdateContactInfoPage extends LoggedInPage{
    public UpdateContactInfoAssertion updateContactInfoAssertion;

    public UpdateContactInfoPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        updateContactInfoAssertion = new UpdateContactInfoAssertion(driver, context);
    }
}
