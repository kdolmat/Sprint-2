package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.SeleniumUtils;

public class getTitle extends TestBase{

    @Test(priority=1)
    public void Login() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(2);
        Assert.assertEquals(driver.getTitle(), title);


    }
}

