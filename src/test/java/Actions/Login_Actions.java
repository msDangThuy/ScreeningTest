package Actions;

import Pages.WordPressLogin;
import Tests.LoginWordPress_01_02;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Login_Actions extends LoginWordPress_01_02 {

    public static void enterValidUsernameAndPassword(WebDriver driver, String username, String password)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(WordPressLogin.btnLoginPage).click();
        driver.findElement(WordPressLogin.txtUsername).sendKeys(username);
        driver.findElement(WordPressLogin.txtPassword).sendKeys(password);
    }

    public static void enterUsernameAndWrongPassword(WebDriver driver, String username, String wrongPassword) {
        driver.findElement(WordPressLogin.btnLoginPage).click();
        driver.findElement(WordPressLogin.txtUsername).sendKeys(username);
        driver.findElement(WordPressLogin.txtPassword).sendKeys(wrongPassword);
    }

    public static void clickLoginButton(WebDriver driver)
    {
        driver.findElement(WordPressLogin.btnLogin).click();
    }
}
