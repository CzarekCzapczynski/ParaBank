package pages;

import assertions.TransferAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransferPage extends LoggedInPage{

    public TransferAssertion transferAssertion;

    public TransferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        transferAssertion = new TransferAssertion(driver);
    }
}
