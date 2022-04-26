package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AirCurtains {

public AirCurtains(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(xpath ="//input[@id='searchval']")
    public WebElement search;

@FindBy(xpath = "//a[@class='btn btn-small btn-primary']")
public WebElement javaclick;

//    @FindBy(xpath ="//input[@value='Add to Cart'])[1]")
//    public WebElement abc;


}
