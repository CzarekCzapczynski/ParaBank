package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class FindTransactionAssertion extends MainPage{
    public FindTransactionAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
