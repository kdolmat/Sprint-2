package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

public class Search extends TestBase {

    //3. Search
//        -log in using correct credentials+
//        -keyword "steam table"+
//        -sort by Price:High to Low+
//        -filter by Food Holding and Warming Equipment+
//        -assertTrue if the page contains keyword "steam table"
//        -add items from 1st page to your cart+

    @Test (priority = 1,groups = "smoke")
    public void login() {


        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
    }


    @Test (priority = 2,groups = "regression")
    public void keyword() {
        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(3);
        SearchPage searchPage = new SearchPage();

        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        //driver.findElement(By.xpath("//input[@name='searchval']")).sendKeys("steam table");

        SeleniumUtils.waitFor(3);
        String expectedText = "steam table";
        String actualText = driver.findElement(By.xpath("//h1[@class='page-header search--title']//span[text()='steam table']")).getText();

        Assert.assertTrue(actualText.contains(expectedText));

    }

    @Test (priority = 3,groups = "regression")
    public void sort() {
//        new Select(driver.findElement(By.xpath("//select[@id='makes']"))).selectByValue("lexus");
//
//        new Select(driver.findElement(By.xpath("//select[@id='models']"))).selectByValue("lexus-gs_350");
//
//        new Select(driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"))).selectByIndex(0);
        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
        SearchPage searchPage = new SearchPage();
        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        SeleniumUtils.waitFor(3);


        SeleniumUtils.scroll(0, 250);
        //new Select(driver.findElement(By.xpath("//select[@id='sort_options']"))).selectByIndex(3);
        new Select(searchPage.clickSort).selectByIndex(3);

        SeleniumUtils.waitFor(3);

    }

    @Test (priority = 4,groups = "regression")
    public void filter() {

        driver.get(PropertyReader.getProperty("url"));
        SeleniumUtils.waitFor(1);
        new LoginPage().loginWithValidCredentials();
        SearchPage searchPage = new SearchPage();
        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        SeleniumUtils.waitFor(3);
        SeleniumUtils.scroll(0, 250);
        new Select(searchPage.clickSort).selectByIndex(3);


        searchPage.clickFilter.click();

        // driver.findElement(By.xpath("//span[text()='Food Holding and Warming Equipment']")).click();

        SeleniumUtils.waitFor(3);
    }

@Test (priority = 6,groups = "regression")
    public void Assert() {

        driver.get(PropertyReader.getProperty("url"));
        new LoginPage().loginWithValidCredentials();
        SeleniumUtils.waitFor(3);
        SearchPage searchPage = new SearchPage();

        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        //driver.findElement(By.xpath("//input[@name='searchval']")).sendKeys("steam table");

        SeleniumUtils.waitFor(3);
        String expectedText = "steam table";
       // String actualText = driver.findElement(By.xpath("//h1[@class='page-header search--title']//span[text()='steam table']")).getText();
         String actualText = searchPage.assertSteamTable.getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }


    @Test (priority = 5,groups = "regression")
    public void addItem() {

        driver.get(PropertyReader.getProperty("url"));
        SeleniumUtils.waitFor(1);
        new LoginPage().loginWithValidCredentials();
        SearchPage searchPage = new SearchPage();
        searchPage.search.sendKeys("steam table" + Keys.ENTER);
        SeleniumUtils.waitFor(3);
        SeleniumUtils.scroll(0, 250);
        new Select(searchPage.clickSort).selectByIndex(3);


        searchPage.clickFilter.click();

        // driver.findElement(By.xpath("//span[text()='Food Holding and Warming Equipment']")).click();

        //driver.findElement(By.xpath("(//input[@class='btn btn-cart btn-small'])[1]")).click();
        searchPage.clickCart.click();
        SeleniumUtils.waitFor(2);
        // driver.findElement(By.xpath("//a[@class='btn btn-small btn-primary']")).click();

        searchPage.viewCart.click();

    }

}




