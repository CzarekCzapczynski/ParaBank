package pages;

import assertions.TransferAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class TransferPage extends LoggedInPage{

    public TransferAssertion transferAssertion;

    @FindBy(css = "#amount")
    private WebElement amountInput;

    @FindBy(css = "#fromAccountId")
    private WebElement fromAccountIdSelect;

    @FindBy(css = "#toAccountId")
    private WebElement toAccountIdSelect;

    @FindBy(css = "[value='Transfer']")
    private WebElement transferButton;

    public TransferPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        transferAssertion = new TransferAssertion(driver, context);
    }

    public TransferPage setAmount(String amount) {
        this.amountInput.sendKeys(amount);
        return this;
    }

    public TransferPage setFromAccountId(String fromAccountId) {
        Select fromAccountIdList = new Select(this.fromAccountIdSelect);
        fromAccountIdList.selectByValue(getContextAttribute(fromAccountId));
        return this;
    }

    public TransferPage setToAccountId(String toAccountId) {
        Select toAccountIdList = new Select(this.toAccountIdSelect);
        toAccountIdList.selectByValue(getContextAttribute(toAccountId));
        return this;
    }

    public TransferPage clickTransferButton() {
        this.transferButton.click();
        return this;
    }
}
