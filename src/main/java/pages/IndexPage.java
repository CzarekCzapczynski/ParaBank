package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends MainPage {
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openParaBank() {
        driver.get("http://parabank.parasoft.com");
    }

    public void fillUserName(String username){
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.cssSelector(".login .button")).click();
    }
}