package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

import java.util.List;

public class LoginAssertion extends MainPage{
    @FindBy(css = ".userInfo")
    private List<WebElement> userInfoElements;

    public LoginAssertion(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserLoggedIn(){
        Assert.assertTrue(userInfoElements.size()!=0);
    }

    public void isUserNotLoggedIn(){
        Assert.assertTrue(userInfoElements.size()==0);
    }

    public void isErrorDisplayed(String errorMessage) {
        String xpathSelector = "//p[contains(.,'" + errorMessage + "')]";
        Assert.assertTrue(driver.findElement(By.xpath(xpathSelector)).isDisplayed());
    }
}
