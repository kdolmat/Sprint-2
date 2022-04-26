package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CouponsPage;
import utilities.SeleniumUtils;

public class Coupons extends TestBase{

    CouponsPage couponsPage = new CouponsPage();



    @Test(groups = "smoke")
    public void couponButton(){

        logger.info("navigate to and click coupon button");
        couponsPage.scrollToCoupons();
        SeleniumUtils.waitFor(2);
        Assert.assertTrue(driver.getCurrentUrl().equals(couponsURL));
    }

    @Test(groups = "regression")
    public void couponPull(){
        logger.info("navigate to url and check coupon buttons");
        couponsPage.scrollToCoupons();
        couponsPage.HotButtonClick();
        SeleniumUtils.switchToWindow("Cholula Hot Sauce & Seasonings - On Sale All Week!");
        Assert.assertTrue(driver.getTitle().equals("Cholula Hot Sauce & Seasonings - On Sale All Week!"));

    }

    @Test(groups = "regression")
    public void addItemFromCoupn(){
        logger.info("navigate to url and add items");
        couponsPage.scrollToCoupons();
        SeleniumUtils.waitFor(2);
        SeleniumUtils.scroll(1,500);
        logger.info("add item");
        couponsPage.HotButtonClick();
        SeleniumUtils.switchToWindow("Cholula Hot Sauce & Seasonings - On Sale All Week!");
        couponsPage.add();

    }

    @Test(groups = "regression")
    public void applyCoupon(){
        logger.info("navigate to url and add items");
        couponsPage.scrollToCoupons();
        String coupon = couponsPage.actualCoupon();
        logger.info("add item");
        couponsPage.HotButtonClick();
        SeleniumUtils.switchToWindow("Cholula Hot Sauce & Seasonings - On Sale All Week!");
        couponsPage.add();
        SeleniumUtils.switchToWindow("WebstaurantStore® Coupon Codes | Save on Restaurant Supplies");
        SeleniumUtils.waitFor(1);
        couponsPage.webstaurantButtonCouponsPage();
        SeleniumUtils.waitFor(1);
        logger.info("add coupon");
        SeleniumUtils.scroll(1,500);
        couponsPage.cartButton();
        couponsPage.couponFill(coupon);
        SeleniumUtils.waitFor(1);
    }

    @Test(groups = "regression")
    public void checkTheDifference(){
        logger.info("navigate to url and add items");
        couponsPage.scrollToCoupons();
        String coupon = couponsPage.actualCoupon();
        logger.info("add item");
        couponsPage.HotButtonClick();
        SeleniumUtils.switchToWindow("Cholula Hot Sauce & Seasonings - On Sale All Week!");
        couponsPage.add();
        SeleniumUtils.switchToWindow("WebstaurantStore® Coupon Codes | Save on Restaurant Supplies");
        SeleniumUtils.waitFor(1);
        couponsPage.webstaurantButtonCouponsPage();
        SeleniumUtils.waitFor(1);
        logger.info("add coupon");
        SeleniumUtils.scroll(1,500);
        couponsPage.cartButton();
        String b4 = couponsPage.priceOf();
        couponsPage.couponFill(coupon);
        SeleniumUtils.waitFor(1);
        String after = couponsPage.priceOf();
        Assert.assertNotEquals(b4,after);
        SeleniumUtils.waitFor(1);
    }
}
