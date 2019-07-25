package Tests;

import Actions.Login_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginWordPress_01_02 {
    public String username = "dangtthuy";
    public String password = "@12341234@";
    public String wrongPassword = password + "wr";
    public WebDriver dr;

    int TimeOut = 20;

    @BeforeMethod
    public void init() {
        System.setProperty("ChromeWebDriver","WebDriver_Resource");
        dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        dr.manage().window().maximize();

        // Navigate to site
        dr.get("https://wordpress.org/plugins/");
        System.out.println(dr.getTitle());
    }

    @Test(description = "Verify that user can login with valid username and password")
    public  void LoginTC01() {
        Login_Actions.enterValidUsernameAndPassword(dr,username,password);
        Login_Actions.clickLoginButton(dr);

        //Verify that user can login with valid username and password
        By txtTextPage = By.xpath(".//body//a[contains(.,'Howdy, ')]");
        Assert.assertEquals(dr.findElement(txtTextPage).getText(),"Howdy, dangtthuy","Pass");
        dr.close();
    }

    @Test(description = "Verify that user cannot login with invalid username and password")
    public  void LoginTC2() {
        Login_Actions.enterUsernameAndWrongPassword(dr,username,wrongPassword);
        Login_Actions.clickLoginButton(dr);

        //Verify that user cannot login with invalid username and password
        By txtTextPage = By.xpath(".//div/a[contains(.,'Lost your password?')]");
        Assert.assertEquals(dr.findElement(txtTextPage).getText(),"Lost your password?","Pass");
    }

    @AfterTest
    public void end()
    {
        dr.quit();
    }
}
