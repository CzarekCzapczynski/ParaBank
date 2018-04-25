import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;

public class SignIn {
    WebDriver driver = new ChromeDriver();




    public void login (String userName, String password) {

        driver.findElement(By.cssSelector("[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div .login .button")).click();
    }

    @Test
    public void shouldLogin() {

        IndexPage indexPage = new IndexPage(driver);

        indexPage.openParaBank();
        indexPage.waitForJStoLoad();
        indexPage.fillUserName("test");
        indexPage.fillPassword("password");
        indexPage.clickLogin();
        indexPage.waitForJStoLoad();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href$='logout.htm']")).isDisplayed());
    }

}
