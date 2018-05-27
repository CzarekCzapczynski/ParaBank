package pages;

import assertions.FindTransactionAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionPage extends LoggedInPage{
    public FindTransactionAssertion findTransactionAssertion;

    public FindTransactionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        findTransactionAssertion = new FindTransactionAssertion(driver);
    }
}
