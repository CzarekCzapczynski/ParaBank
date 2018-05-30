package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public abstract class LoggedInPage extends MainPage{
    public MenuPage leftMenu;

    public LoggedInPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        this.leftMenu = new MenuPage(driver, context);
    }
}
