package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CouponsPage;

public class Coupons extends TestBase{

    CouponsPage couponsPage = new CouponsPage();
    //CartPage cartPage = new CartPage();

    @DataProvider
    public Object[][] coupon(){
        return new Object[][]{
                {couponsPage.actualCoupon()}
               };
    }

    @Test(priority = 0, groups = "smoke")
    public void couponButton(){

        couponsPage.scrollToCoupons();
        Assert.assertTrue(driver.getCurrentUrl().equals(couponsURL));
    }

    @Test(priority = 1)
    public void couponPull(){

        couponsPage.scrollToCoupons();
        System.out.println(couponsPage.actualCoupon());

    }
}
