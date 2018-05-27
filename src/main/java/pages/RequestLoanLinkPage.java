package pages;

import assertions.RequestLoanLinkAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanLinkPage extends LoggedInPage{
    public RequestLoanLinkAssertion requestLoanLinkAssertion;

    public RequestLoanLinkPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        requestLoanLinkAssertion = new RequestLoanLinkAssertion(driver);
    }
}
