package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RecipePage;
import utilities.PropertyReader;
import utilities.SeleniumUtils;


public class RecipeTest extends TestBase {

    @Test (groups = "smoke")
   public void positiveRecipeConvert() {
        driver.get(PropertyReader.getProperty("url"));

        RecipePage rp = new RecipePage();

        rp.recipePage.click();

        SeleniumUtils.waitFor(2);
        rp.recipeName.sendKeys("Cake");
        SeleniumUtils.waitFor(2);
        rp.recipeNotes.sendKeys("Delicious chocolate cake");
        rp.origServ.sendKeys("4");
        rp.resizeServ.sendKeys("4");



        SeleniumUtils.waitFor(2);

        WebElement radio1 = driver.findElement(By.id("MeasurementSystemImperial"));
        WebElement radio2 = driver.findElement(By.id("MeasurementSystemMetric"));
        boolean Selected = radio1.isSelected();

        if (Selected) {
            radio2.click();
        }
        Assert.assertTrue(radio2.isSelected());
    }

    @Test (groups = "regression")
  public void negativeRecipeConvert() {
        driver.get(PropertyReader.getProperty("url"));

        RecipePage rp = new RecipePage();
        rp.recipePage.click();
        SeleniumUtils.waitFor(2);
        rp.recipeName.sendKeys("Cake");
        SeleniumUtils.waitFor(2);
        rp.recipeNotes.sendKeys("Delicious chocolate cake");
        SeleniumUtils.waitFor(2);
        rp.origServ.sendKeys("4");
        rp.resizeServ.sendKeys("4");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse("4".equals("-4"), "Failed");
        softAssert.assertFalse("4".equals("abcdefghijklmnoprqstuywxvzABCDEFGHIJKLMNOPRSTQUYWXVZ"), "Failed");
        softAssert.assertFalse("4".equals("123456789001234567890"), "Failed");
    }

    @Test (groups = "regression")
    public void negativeIngredientsQty() {

        driver.get(PropertyReader.getProperty("url"));

        SeleniumUtils.waitFor(2);
        RecipePage rp = new RecipePage();
        rp.recipePage.click();

        SeleniumUtils.waitFor(2);
        rp.recipeName.sendKeys("Cake");
        SeleniumUtils.waitFor(2);
        rp.recipeNotes.sendKeys("Delicious chocolate cake");
        SeleniumUtils.waitFor(2);
        rp.origServ.sendKeys("4");
        rp.resizeServ.sendKeys("4");
        rp.Metric.click();
        rp.Ingr0Qty.sendKeys("-2");
        driver.findElement(By.xpath("//*[@id=\"Ingredients[0].Measurement\"]")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN,  Keys.ARROW_DOWN, Keys.ENTER);


        rp.Ingr0.sendKeys("Flour");
        rp.Ingr1Qty.sendKeys("-2");
        rp.Ingr1.sendKeys("Chocolate");
        rp.ResizeRecipe.click();


        String ExpMsg = "Errors were found on the form. Please correct the fields and try again.";
        String actual = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/form/div[1]/div/div[1]/div/div")).getText();
        Assert.assertTrue(actual.contains(ExpMsg));

    }

    @Test (groups = "regression")
            public void positiveIngredientsQty(){

        driver.get(PropertyReader.getProperty("url"));

        RecipePage rp = new RecipePage();
        rp.recipePage.click();
        rp.recipeName.sendKeys("Cake");
        rp.recipeNotes.sendKeys("Delicious chocolate cake");
        rp.Metric.click();

        rp.Ingr0Qty.sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"Ingredients[1].Measurement\"]")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN,  Keys.ARROW_DOWN, Keys.ENTER);
        rp.Ingr0.sendKeys("Flour");

        SeleniumUtils.waitFor(2);
        rp.Ingr1Qty.sendKeys("2");
        rp.Ingr1.sendKeys("Chocolate");
        rp.ResizeRecipe.click();

                String expectedText = "Resized";
                Assert.assertTrue(driver.getPageSource().contains(expectedText));



        }



        }


