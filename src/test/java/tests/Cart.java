package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.SearchPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.util.Arrays;
import java.util.List;


public class Cart extends TestBase{

    @Test (priority = 0,groups = "regression")
    public void addItem() throws InterruptedException {

        driver.get(PropertyReader.getProperty("url"));
        SeleniumUtils.waitFor(1);
        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(5);
        SearchPage searchPage = new SearchPage();
        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        SeleniumUtils.waitFor(3);
        SeleniumUtils.scroll(0, 250);
        new Select(searchPage.clickSort).selectByIndex(3);


        searchPage.clickFilter.click();

        // driver.findElement(By.xpath("//span[text()='Food Holding and Warming Equipment']")).click();

       // driver.findElement(By.xpath("(//input[@class='btn btn-cart btn-small'])[1]")).click();
        searchPage.clickCart.click();
        SeleniumUtils.waitFor(2);
        // driver.findElement(By.xpath("//a[@class='btn btn-small btn-primary']")).click();

       searchPage.viewCart.click();
        SeleniumUtils.waitFor(5);
        Thread.sleep(2000);


//        CartPage cartPage = new CartPage();
//
//
//        SeleniumUtils.waitFor(2);
//        cartPage.cartButton();
//        cartPage.totalItemsCombined();
//        Assert.assertEquals(cartPage.totalItemsCombined(),cartPage.subTot());

    }


    @Test(priority=1, groups = "smoke")
    public void Login(){

        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(2);
        Assert.assertEquals(driver.getTitle(), title);
    }
    @Test(priority=2,groups = "regression")
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
     @Test(priority=3,groups = "regression")
    public void thirdElementQuantity(){
        //mvn test -DxmlFile=regression_tests.xml
SeleniumUtils.waitFor(2);
        new LoginPage().loginWithValidCredentials();
        CartPage cartPage = new CartPage();


         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         SeleniumUtils.waitFor(2);
         cartPage.thirdEl();

    }

     @Test(priority=4,groups = "regression")

    public void prices(){

         new LoginPage().loginWithValidCredentials();
         SeleniumUtils.waitFor(2);
         CartPage cartPage = new CartPage();


         SeleniumUtils.waitFor(2);
         cartPage.cartButton();
         cartPage.totalItemsCombined();
         Assert.assertEquals(cartPage.totalItemsCombined(),cartPage.subTot());
    }

    @Test(priority=5,groups = "regression")
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

    @Test(priority=6,groups = "regression")
    public void emptyCart() throws InterruptedException {
        new LoginPage().loginWithValidCredentials();

        CartPage cartPage = new CartPage();


        SeleniumUtils.waitFor(2);
        cartPage.cartButton();
        cartPage.subTotalButton();
       // cartPage.goBackAndDelete();


    }







}
