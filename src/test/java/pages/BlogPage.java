package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlogPage {


    public BlogPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Blog']")
    public WebElement BlogClick;

    @FindBy(xpath = "(//a[@class='col-xs-4 post-preview'])[1]")
    public WebElement easter;
    @FindBy(xpath = "(//a[@class='col-xs-6 col-xs-3 post-preview'])[1]")
    public WebElement holiday;
    @FindBy(xpath = "(//a[@class='col-xs-6 col-xs-3 post-preview'])[4]")
    public WebElement mirepoix;
    @FindBy(xpath = "//a[.='Shop All Air Curtains']")
    public WebElement shopCurtains;

    @FindBy(xpath = "//input[@value='Add to Cart'])[1]")
    public WebElement ccc;


}




