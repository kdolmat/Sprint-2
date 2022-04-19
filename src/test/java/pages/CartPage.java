package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='hidden xsl:inline']")
    public WebElement cartPage;

    @FindBy (xpath = "//span[@class='itemDescription description']")
    public static List<WebElement> cartItems;

    @FindBy(xpath ="(//button[@name='quantityButtonUp'])[1]")
    public WebElement thridElement;

    @FindBy(xpath = "//div[@class='itemTotal total']")
    public static List<WebElement> prices;

    @FindBy(xpath = "(//p[@class='subtotal'])[4]")
    public WebElement subTotal;

    @FindBy(xpath = "//button[@class='standardCheckoutButton btn btn-checkout btn-block btn-large clears']")
    public WebElement SubTotalButton;

    @FindBy(id="big-total-display")
    public WebElement totalAfterTaxes;

    @FindBy(xpath = "//a[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement clearCartButton;

    @FindBy(xpath = "//button[text()='Empty Cart']")
    public WebElement confirmDeletion;

    public void cartButton(){
        cartPage.click();
    }

    public void thirdEl(){
        thridElement.click();
        thridElement.click();
    }

    public String totalItemsCombined(){
        List<String>noDollar$=new ArrayList<>();
        List<Double>itemsPrice=new ArrayList<>();
        double temp = 0;
        List<String> price = SeleniumUtils.getElementsText(prices);
        for(int i=0;i<price.size();i++){
            if(price.get(i).contains("$")){
                noDollar$.add(price.get(i).replaceAll("[$,]", ""));
                itemsPrice.add(Double.parseDouble(noDollar$.get(i)));
                temp+= itemsPrice.get(i);
            }
        }
        String priceDollar$ = String.valueOf(temp);
        String fixed = "$"+priceDollar$.substring(0,3)+","+priceDollar$.substring(2,9);

        return fixed;
    }

    public String subTot(){
        String subTotalText = subTotal.getText();
        return subTotalText;
    }

    public void subTotalButton(){
        SubTotalButton.click();
    }

    public String totAfterTaxes(){
        String AT = totalAfterTaxes.getText();
        return AT;
    }

    public void goBackAndDelete() throws InterruptedException {
        Driver.getDriver().navigate().back();
        clearCartButton.click();
        Thread.sleep(2000);
        Driver.getDriver().switchTo().activeElement();
        confirmDeletion.click();

    }







}
