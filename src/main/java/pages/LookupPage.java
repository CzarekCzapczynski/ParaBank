package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LookupPage extends RegisterPage {
    public LookupPage(WebDriver driver) {
        super(driver);
    }
    public void clickFindMyLoginInfoButton() {
        driver.findElement(By.cssSelector("[value^='Find']")).click();
    }
}
