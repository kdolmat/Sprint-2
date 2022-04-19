package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewAccountPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

public class CreateAccountTest extends TestBase {

    @Test(groups = "smoke")
    public void negativeLoginTest() {
        driver.get(PropertyReader.getProperty("url"));



        NewAccountPage newAcc = new NewAccountPage();
        newAcc.registerPage.click();
        newAcc.email.sendKeys(PropertyReader.getProperty("username"));
        SeleniumUtils.waitFor(2);
        newAcc.password.sendKeys(PropertyReader.getProperty("password"));


        Assert.assertTrue(driver.getPageSource().contains("This email already belongs to an account. "));




    }


}