package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//input[@name='searchval']")
    public WebElement search;

    @FindBy(xpath = "//select[@id='sort_options']")
    public WebElement clickSort;

    @FindBy(xpath = "//span[text()='Food Holding and Warming Equipment']")
    public WebElement clickFilter;

    @FindBy(xpath = "(//input[@class='btn btn-cart btn-small'])[1]")
    public WebElement clickCart;

    @FindBy(xpath = "//a[@class='btn btn-small btn-primary']")
    public WebElement viewCart;

    @FindBy(xpath = "//h1[@class='page-header search--title']//span[text()='steam table']")
    public WebElement assertSteamTable;
}
