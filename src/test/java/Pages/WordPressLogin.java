package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WordPressLogin {
    public static By btnLoginPage = By.id("wp-admin-bar-log-in");
    public static By txtUsername = By.id("user_login");
    public static By txtPassword = By.id("user_pass");
    public static By btnLogin = By.id("wp-submit");
}
