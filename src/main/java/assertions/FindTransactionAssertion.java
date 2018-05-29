package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class FindTransactionAssertion extends MainPage{

    @FindBy(css = "#transactionTable")
    private WebElement transactionTable;

    public FindTransactionAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isTransactionFound() {
        Assert.assertTrue(transactionTable.isDisplayed());
    }
}
