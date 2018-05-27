package pages;

import assertions.BillPayAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage extends LoggedInPage{
    public BillPayAssertion billPayAssertion;

    public BillPayPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        billPayAssertion = new BillPayAssertion(driver);
    }
}
