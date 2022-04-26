package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Cart {

    public Cart(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


@FindBy(xpath = "//select[@id='address_type']")
    public WebElement ships;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zip;

    @FindBy(xpath = "//input[@id='calculate_button']")
    public WebElement click;

    @FindBy(xpath = "//button[@class='standardCheckoutButton btn btn-checkout btn-block btn-large clears']")
    public WebElement check;

}
