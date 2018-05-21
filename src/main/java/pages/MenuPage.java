package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage{

    @FindBy(css = "[href*='overview.htm']")
    private WebElement accountsOverviewLink;

    @FindBy(css = "[href*='openaccount.htm']")
    private WebElement openNewAccountLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverviewLink(){
        accountsOverviewLink.click();
        waitForJStoLoad();
        return new AccountPage(driver);
    }

    public OpenAccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        waitForJStoLoad();
        return new OpenAccountPage(driver);
    }
}
