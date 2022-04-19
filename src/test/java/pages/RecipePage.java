package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RecipePage {



 public RecipePage() {
  PageFactory.initElements(Driver.getDriver(), this);
 }
 @FindBy (partialLinkText = "Recipe Resizer")
 public WebElement recipePage;

 @FindBy (xpath = "//input[@name=\"RecipeName\"]")
 //@FindBy (xpath = "(//input[@style=‘height:42px’])[1]")
 public WebElement recipeName;

 @FindBy (xpath= "//textarea[@id=\"Notes\"]")
 public WebElement recipeNotes;

 @FindBy (name = "OriginalServings")
 public WebElement origServ;

 @FindBy (name = "ResizedServings")
 public WebElement resizeServ;

 @FindBy (id = "MeasurementSystemMetric")
 public WebElement Metric;

 @FindBy (name = "Ingredients[0].Quantity")
 public WebElement Ingr0Qty;

 @FindBy (name = "Ingredients[0].Ingredient")
 public WebElement Ingr0;

 @FindBy (name = "Ingredients[1].Quantity")
 public WebElement Ingr1Qty;

 @FindBy (name = "Ingredients[1].Ingredient")
 public WebElement Ingr1;

 //@FindBy (xpath = "(//button[@type[‘submit’]])[1]")
 @FindBy(xpath = "(//div//button)[15]")
 public WebElement ResizeRecipe;









    }

