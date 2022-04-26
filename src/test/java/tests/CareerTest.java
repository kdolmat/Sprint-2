package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareerPage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.util.Set;

public class CareerTest extends TestBase {

    @Test(groups = "smoke")
    public void searchForJob() {

        logger.info("Navigate to url");
        driver.get(PropertyReader.getProperty("url"));

        CareerPage cp = new CareerPage();
        cp.careerPage.click();

        String ExpectedJobs = "Jobs";

        Assert.assertEquals((cp.ActualJobs).getText(), ExpectedJobs);

        cp.StatePosition.click();
        cp.Dev.click();
    }

    @Test
    public void JobPosition() {
        logger.info("Navigate to url");
        driver.get(PropertyReader.getProperty("url"));
        CareerPage cp = new CareerPage();
        cp.careerPage.click();
        SeleniumUtils.waitFor(2);
        cp.StatePosition.click();
        cp.Dev.click();

        Actions ac = new Actions(driver);
        WebElement position = driver.findElement(By.partialLinkText("QA Automation Engineer (Remote)"));
        SeleniumUtils.waitFor(2);
        ac.moveToElement(position).click();
    }

    @Test
    public void StartYourCareer() {
        logger.info("Navigate to url");
        driver.get(PropertyReader.getProperty("url"));
        CareerPage cp = new CareerPage();
        cp.careerPage.click();

        SeleniumUtils.scroll(1, 1400);
        SeleniumUtils.waitFor(2);
        cp.Play.click();


        WebElement FrameElement = driver.findElement(By.xpath("//iframe[@src=\"//www.youtube.com/embed/xCbkCcuyvHY?rel=0&amp;hd=1\"]"));
        driver.switchTo().frame(FrameElement);
        SeleniumUtils.waitFor(2);
        SeleniumUtils.scroll(1, 500);
        cp.youTube.click();

        String expectedVideoname = "Working at WebstaurantStore";


        Assert.assertFalse(cp.videoName.equals(expectedVideoname));


    }

    @Test
    public void choosePosition() {
        logger.info("Navigate to url");
        driver.get(PropertyReader.getProperty("url"));
        CareerPage cp = new CareerPage();
        cp.careerPage.click();
        SeleniumUtils.waitFor(2);
        cp.StatePosition.click();
        cp.Dev.click();

        cp.firstPosition.click();

        SeleniumUtils.switchToWindow("Accessibility Engineer (Remote Friendly) | Tampa, FL | WebstaurantStore Careers");

        cp.apply.click();

        //driver.findElement(By.partialLinkText("I am applying for:"));

        cp.firstName.sendKeys("John");
        SeleniumUtils.waitFor(2);
        cp.lastName.sendKeys("Depp");
        SeleniumUtils.waitFor(2);
        cp.address.sendKeys("123 Main str");
        SeleniumUtils.waitFor(2);
        cp.confirmAddress.sendKeys("123 Main str");
        cp.zip.sendKeys("11111");
        cp.email.sendKeys("florida@yahoo.com");
        SeleniumUtils.waitFor(2);
        cp.phone.sendKeys("9177198766");
        cp.education.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        SeleniumUtils.waitFor(2);
        cp.yes.isSelected();
        SeleniumUtils.waitFor(2);
        cp.immigration.isSelected();
        cp.crime.isSelected();
        SeleniumUtils.waitFor(2);
        cp.referral.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        cp.submit.click();
        SeleniumUtils.waitFor(2);

        String text = "We're sorry, there was a problem submitting your application. Please enter the fields below in red and resubmit.";
        WebElement actual = driver.findElement(By.id("client-side-error-message"));

        Assert.assertTrue(actual.getText().contains(text));

    }

    @Test
    public void WebstaurantStore() {
        logger.info("Navigate to url");
        driver.get(PropertyReader.getProperty("url"));
        CareerPage cp = new CareerPage();
        cp.careerPage.click();
        SeleniumUtils.waitFor(2);

        SeleniumUtils.scroll(1, 6600);

        SeleniumUtils.waitFor(2);
        driver.findElement(By.xpath("//a[@class=\"careers-footer-logo\"]")).click();

        SeleniumUtils.switchToWindow("WebstaurantStore: Restaurant Supplies & Foodservice Equipment");
        String text = "WebstaurantStore: Restaurant Supplies & Foodservice Equipment";

        SeleniumUtils.waitFor(2);
        Assert.assertTrue(driver.getTitle().contains(text));

    }

}




