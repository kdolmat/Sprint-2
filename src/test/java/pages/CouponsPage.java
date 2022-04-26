package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

public class CouponsPage {



    public CouponsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(xpath = "//a[text()='Coupons']")
    public WebElement couponsButton;

    @FindBy(xpath = "//div//div//h3[text()[contains(.,'HOT')]]")
    public WebElement couponItself;

    @FindBy(xpath = "//span[@class='hidden xsl:inline']")
    public WebElement cartPage;

    @FindBy(xpath = "//a[@href='https://www.webstaurantstore.com/feature/24147/mccormick-cholula-sale-4-25-22/']")
    public WebElement hotButton;

    @FindBy(xpath = "//a[text()='WebstaurantStore']")
    public WebElement webstaurantButtonCouponsPage;

    @FindBy(xpath = "//input[@class='discountCode coupon-code']")
    public WebElement couponsBox;

    @FindBy(xpath = "(//input[@value='Add to Cart'])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "(//div[@class='itemPrice price'])[1]")
    public WebElement price;

    public String couponPull;



    public void cartButton(){
        cartPage.click();
    }

    public void webstaurantButtonCouponsPage(){
        webstaurantButtonCouponsPage.click();
    }

    public String actualCoupon(){
        couponPull = couponItself.getText().substring(10);
        return "HOT";
    }

    public String priceOf(){
        String p=price.getText();
        return p;

    }

    public void HotButtonClick(){
        hotButton.click();
    }

    public void couponFill(String couponGet){
       couponsBox.sendKeys(couponGet + Keys.ENTER);
    }

    public void add(){
        addToCart.click();
    }


    public void scrollToCoupons(){

        SeleniumUtils.scroll(1,2700);
        SeleniumUtils.jsClick(couponsButton);
    }









}
