package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends MainPage{
    public AccountPage(WebDriver driver){
        super(driver);
    }

    public boolean isUserLoggedIn(){
        return driver.findElement(By.cssSelector("a[href$='logout.htm']")).isDisplayed();
    }
}
