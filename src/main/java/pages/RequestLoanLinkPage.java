package pages;

import assertions.RequestLoanLinkAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RequestLoanLinkPage extends LoggedInPage{
    public RequestLoanLinkAssertion requestLoanLinkAssertion;

    public RequestLoanLinkPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        requestLoanLinkAssertion = new RequestLoanLinkAssertion(driver, context);
    }
}
