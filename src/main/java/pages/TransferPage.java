package pages;

import assertions.TransferAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public TransferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        transferAssertion = new TransferAssertion(driver);
    }

    public TransferPage setAmount(String amount) {
        this.amountInput.sendKeys(amount);
        return this;
    }

    public TransferPage setFromAccountId(int fromAccountId) {
        Select fromAccountIdList = (Select)this.fromAccountIdSelect;
        fromAccountIdList.selectByIndex(fromAccountId);
        return this;
    }

    public TransferPage setToAccountId(int toAccountId) {
        Select toAccountIdList = (Select)this.toAccountIdSelect; 
        toAccountIdList.selectByIndex(toAccountId);
        return this;
    }

    public TransferPage clickTransferButton() {
        this.transferButton.click();
        return this;
    }
}
