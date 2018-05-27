package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class RequestLoanLinkAssertion extends MainPage{
    public RequestLoanLinkAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
