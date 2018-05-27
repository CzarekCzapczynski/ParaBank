package pages;

import assertions.UpdateContactInfoAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfoPage extends LoggedInPage{
    public UpdateContactInfoAssertion updateContactInfoAssertion;

    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        updateContactInfoAssertion = new UpdateContactInfoAssertion(driver);
    }
}
