package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class UpdateContactInfoAssertion extends MainPage{
    public UpdateContactInfoAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
