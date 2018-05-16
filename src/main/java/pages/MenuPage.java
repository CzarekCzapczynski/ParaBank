package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends MainPage{

    @FindBy(css = "[href*='overview.htm']")
    private WebElement accountsOverviewLink;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickAccountsOverview(){
        accountsOverviewLink.click();
        return new AccountPage(driver);
    }
}
