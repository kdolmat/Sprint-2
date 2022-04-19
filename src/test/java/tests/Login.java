package tests;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

public class Login extends TestBase {
    //2.login and verify
//-incorrect password(negative test case)+
//-incorrect username(negative test case)+
//-login using correct credentials +
//-verity log in by logging out
//-log in again

    @Test(groups = "smoke")
    public void LoginVerify() {

        driver.get(PropertyReader.getProperty("url"));

        new LoginPage().loginWithValidCredentials();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.webstaurantstore.com/myaccount/");

    }

    @Test(groups = "regression")
    public void incorrectUsername() {

        driver.get(PropertyReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.accountClick.click();

        loginPage.emailAddress.sendKeys("dolmat.kirillgmail.com");
        loginPage.password.sendKeys(PropertyReader.getProperty("password"));
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Sign In or Create an Account!");
    }


    @Test(groups = "regression")
    public void incorrectPassword() {

        driver.get(PropertyReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.accountClick.click();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("password"));
        loginPage.password.sendKeys("=kjsZF6@hqLP7d");
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getTitle(), "Sign In or Create an Account!");

    }


    @Test(groups = "regression")
    public void loginVerifyCorrect() {

        driver.get(PropertyReader.getProperty("url"));

        new LoginPage().loginWithValidCredentials();



    }


    @Test(groups = "smoke")
    public void logout(){

        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
        LoginPage loginPage =new LoginPage();

        loginPage.robinsAccount.click();
        loginPage.logout.click();


        SeleniumUtils.waitFor(3);

        String text="Create an Account";

        Assert.assertEquals(driver.getTitle(), "Sign In or Create an Account!");





    }

    @Test(groups = "smoke")
    public void loginAgain(){

        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
        LoginPage loginPage =new LoginPage();
        SeleniumUtils.waitFor(2);
        loginPage.robinsAccount.click();
        loginPage.logout.click();


        SeleniumUtils.waitFor(2);

        String text="Create an Account";

        new LoginPage().loginWithValidCredentials();

        SeleniumUtils.waitFor(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.webstaurantstore.com/myaccount");

    }




}