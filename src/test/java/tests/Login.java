package tests;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.PropertyReader;

public class Login extends TestBase {
    //2.login and verify
//-incorrect password(negative test case)+
//-incorrect username(negative test case)+
//-login using correct credentials +
//-verity log in by logging out
//-log in again

    @Test(groups = "smoke")
    public void Login() {

        driver.get(PropertyReader.getProperty("url"));

        new LoginPage().loginWithValidCredentials();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.webstaurantstore.com/myaccount/");

    }

    @Test
    public void incorrectUsername() {

        driver.get(PropertyReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.accountClick.click();

        loginPage.emailAddress.sendKeys("dolmat.kirillgmail.com");
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Sign In or Create an Account!");
    }


    @Test
    public void incorrectPassword() {

        driver.get(PropertyReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.accountClick.click();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("email"));
        loginPage.password.sendKeys("=kjsZF6@hqLP7d");
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Sign In or Create an Account!");

    }


    @Test
    public void logOut() throws InterruptedException {


        driver.get(PropertyReader.getProperty("url"));

        new LoginPage().loginWithValidCredentials();

        LoginPage loginPage = new LoginPage();

        loginPage.logoutClick.click();
        Thread.sleep(2000);
    }


}