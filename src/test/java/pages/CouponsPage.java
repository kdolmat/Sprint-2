package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import utilities.Driver;
import utilities.SeleniumUtils;

public class CouponsPage {
    public String coupon;

    public CouponsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
}


    @FindBy(xpath = "//a[text()='Coupons']")
    public WebElement couponsButton;

    @FindBy(xpath = "//h2[text()='Use Coupon Code: EASTER']")
    public WebElement couponItself;



    public void scrollToCoupons(){

        SeleniumUtils.scroll(1,2500);
        SeleniumUtils.jsClick(couponsButton);
    }

    public String actualCoupon(){
        return coupon = couponItself.getText().substring(17);
    }






}
