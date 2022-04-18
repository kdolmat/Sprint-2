package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Account extends TestBase{

    @Test(priority=1)
    public void wrongLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.newCredentials();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), title);
    }
}
