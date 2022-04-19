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
    public void Login(){

        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(2);
        Assert.assertEquals(driver.getTitle(), title);
    }
    @Test(priority=2)
    public void cartMatch(){
        new LoginPage().loginWithValidCredentials();
        CartPage cartPage = new CartPage();


        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        String expected = " Steam Table ";
        List<String>a= Arrays.asList(" Steam Table ");
        List<String> actual = SeleniumUtils.getElementsText(cartPage.cartItems);
        Assert.assertFalse(a.contains(actual));//doesn't match
    }
     @Test(priority=3)
    public void thirdElementQuantity(){

        new LoginPage().loginWithValidCredentials();
        CartPage cartPage = new CartPage();


         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         SeleniumUtils.waitFor(2);
         cartPage.thirdEl();

    }

     @Test(priority=4)
    public void prices(){
         new LoginPage().loginWithValidCredentials();
         CartPage cartPage = new CartPage();


         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         cartPage.totalItemsCombined();
         Assert.assertEquals(cartPage.totalItemsCombined(),cartPage.subTot());
    }

    @Test(priority=5)
    public void checkOut(){

        new LoginPage().loginWithValidCredentials();
        CartPage cartPage = new CartPage();


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
        new LoginPage().loginWithValidCredentials();

        CartPage cartPage = new CartPage();


        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        cartPage.subTotalButton();
        cartPage.goBackAndDelete();


    }







}
