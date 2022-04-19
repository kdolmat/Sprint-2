package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Account extends TestBase{

    @Test(priority=1, groups = "smoke")
    public void wrongLogin() throws InterruptedException {

        new LoginPage().loginWithValidCredentials();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), title);
    }
}
