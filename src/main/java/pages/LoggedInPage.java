package pages;

import org.openqa.selenium.WebDriver;

public abstract class LoggedInPage extends MainPage{
    public MenuPage leftMenu;

    public LoggedInPage(WebDriver driver) {
        super(driver);
        this.leftMenu = new MenuPage(driver);
    }
}
