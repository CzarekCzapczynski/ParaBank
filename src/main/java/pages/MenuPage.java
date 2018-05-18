package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends MainPage{

    @FindBy(css = "[href*='overview.htm']")
    private WebElement accountsOverviewLink;

    @FindBy(css = "[href*='openaccount.htm']")
    private WebElement openNewAccountLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickAccountsOverviewLink(){
        accountsOverviewLink.click();
        return new AccountPage(driver);
    }

    public AccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        return new AccountPage(driver);
    }
}
