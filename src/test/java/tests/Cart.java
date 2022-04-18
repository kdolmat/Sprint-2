package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utilities.SeleniumUtils;

import java.util.Arrays;
import java.util.List;


public class Cart extends TestBase{


    @Test(priority=1)
    public void Login() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.absoluteLogin();
        SeleniumUtils.waitFor(2);
        Assert.assertEquals(driver.getTitle(), title);
    }
    @Test(priority=2)
    public void cartMatch() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();

        loginPage.absoluteLogin();
        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        String expected = " Steam Table ";
        List<String>a= Arrays.asList(" Steam Table ");
        List<String> actual = SeleniumUtils.getElementsText(cartPage.cartItems);
        Assert.assertTrue(actual.contains(a));//doesn't match
    }
     @Test(priority=3)
    public void thirdElementQuantity() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();

         loginPage.absoluteLogin();
         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         cartPage.thirdEl();

    }

     @Test(priority=4)
    public void prices() throws InterruptedException {
         LoginPage loginPage = new LoginPage();
         CartPage cartPage = new CartPage();

         loginPage.absoluteLogin();
         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         cartPage.totalItemsCombined();
         Assert.assertEquals(cartPage.totalItemsCombined(),cartPage.subTot());
    }

    @Test(priority=5)
    public void checkOut() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();

        loginPage.absoluteLogin();
        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        cartPage.totalItemsCombined();
        Assert.assertEquals(cartPage.totalItemsCombined(),cartPage.subTot());
        String total = cartPage.totalItemsCombined();
        cartPage.subTotalButton();
        Assert.assertNotEquals(total,cartPage.totAfterTaxes());
    }

    @Test(priority=6)
    public void emptyCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();

        loginPage.absoluteLogin();
        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        cartPage.subTotalButton();
        cartPage.goBackAndDelete();


    }







}
