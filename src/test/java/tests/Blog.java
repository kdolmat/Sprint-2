package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AirCurtains;
import pages.BlogPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;
import pages.Cart;


public class Blog extends TestBase {


    @Test(groups = "smoke")
    public void test1() {


        logger.info("navigate to url");
        driver.get(PropertyReader.getProperty("url"));
        BlogPage blogPage = new BlogPage();
        SeleniumUtils.scroll(0, 2500);
        SeleniumUtils.waitFor(2);
        blogPage.BlogClick.click();

        SeleniumUtils.hover(blogPage.easter);
        Actions act = new Actions(driver);
        act.moveToElement(blogPage.easter).clickAndHold().build().perform();
        SeleniumUtils.waitFor(3);
        act.moveToElement(blogPage.holiday).clickAndHold().build().perform();
        act.moveToElement(blogPage.mirepoix).clickAndHold().build().perform();

        logger.info("check url");
        String title = "WebstaurantStore Blog: Trends, Resources, How-Tos, & More";
        Assert.assertEquals(driver.getTitle(), title);


    }

    @Test
    public void test2() {

        driver.get(PropertyReader.getProperty("url"));


        BlogPage blogPage = new BlogPage();
        SeleniumUtils.scroll(0, 2500);

        blogPage.BlogClick.click();


        blogPage.shopCurtains.click();

//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String windowHandle : windowHandles) {
//            if (!windowHandle.equals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//            }
//        }
        //SeleniumUtils.switchToWindow()
        //  driver.findElement(By.xpath("//input[@name='searchval']")).sendKeys("abddf");
        SeleniumUtils.waitFor(5);
        logger.info("swtich to window");


        SeleniumUtils.switchToWindow("Commercial Air Curtains & Air Doors - WebstaurantStore");

        AirCurtains airCurtains = new AirCurtains();

        logger.info("send kesy air curtain cooler");
        airCurtains.search.sendKeys("air curtain cooler" + Keys.ENTER);

        SeleniumUtils.waitFor(2);


    }

    @Test
    public void test3() {


        driver.get(PropertyReader.getProperty("url"));
        BlogPage blogPage = new BlogPage();
        SeleniumUtils.scroll(0, 2500);
        blogPage.BlogClick.click();
        blogPage.shopCurtains.click();
        SeleniumUtils.switchToWindow("Commercial Air Curtains & Air Doors - WebstaurantStore");
        AirCurtains airCurtains = new AirCurtains();
        airCurtains.search.sendKeys("air curtain cooler" + Keys.ENTER);
        SeleniumUtils.waitFor(3);
        driver.findElement(By.xpath("(//input[@value='Add to Cart'])[1]")).click();


        logger.info("scroll the page");
        SeleniumUtils.scroll(0, 250);


        SeleniumUtils.jsClick(airCurtains.javaclick);
        SeleniumUtils.waitFor(3);


    }

    @Test
    public void test4() {


        driver.get(PropertyReader.getProperty("url"));
        BlogPage blogPage = new BlogPage();
        SeleniumUtils.scroll(0, 2500);
        blogPage.BlogClick.click();
        blogPage.shopCurtains.click();
        SeleniumUtils.waitFor(3);
        SeleniumUtils.switchToWindow("Commercial Air Curtains & Air Doors - WebstaurantStore");
        AirCurtains airCurtains = new AirCurtains();
        SeleniumUtils.waitFor(2);
        airCurtains.search.sendKeys("air curtain cooler" + Keys.ENTER);
        SeleniumUtils.waitFor(2);
        driver.findElement(By.xpath("(//input[@value='Add to Cart'])[1]")).click();

        SeleniumUtils.scroll(0, 250);

        logger.info("javaClick");
        SeleniumUtils.jsClick(airCurtains.javaclick);
        SeleniumUtils.waitFor(3);

        SeleniumUtils.scroll(0, 450);

        Cart cart = new Cart();


        new Select(cart.ships).selectByIndex(1);
        SeleniumUtils.waitFor(3);

        cart.zip.sendKeys("94027");

        cart.click.click();
        SeleniumUtils.waitFor(3);

        logger.info("title is:WebstaurantStore Cart");
        String title = "WebstaurantStore Cart";
        Assert.assertEquals(driver.getTitle(), title);


    }

    @Test
    public void test5() {


        driver.get(PropertyReader.getProperty("url"));
        BlogPage blogPage = new BlogPage();
        SeleniumUtils.scroll(0, 2500);
        blogPage.BlogClick.click();
        blogPage.shopCurtains.click();
        SeleniumUtils.switchToWindow("Commercial Air Curtains & Air Doors - WebstaurantStore");
        AirCurtains airCurtains = new AirCurtains();
        airCurtains.search.sendKeys("air curtain cooler" + Keys.ENTER);

        driver.findElement(By.xpath("(//input[@value='Add to Cart'])[1]")).click();

        SeleniumUtils.scroll(0, 250);


        SeleniumUtils.jsClick(airCurtains.javaclick);
        SeleniumUtils.waitFor(3);

        SeleniumUtils.scroll(0, 450);


        Cart cart = new Cart();


        new Select(cart.ships).selectByIndex(1);
        SeleniumUtils.waitFor(3);

        cart.zip.sendKeys("94027");

        cart.click.click();
        SeleniumUtils.waitFor(3);


        logger.info("click to checkout");
        cart.check.click();
        SeleniumUtils.waitFor(3);


    }
}