package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.PropertyReader;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(xpath = "//a[@data-testid='login-nav-link']")
    public WebElement accountClick;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;


    @FindBy(xpath = "//input[@id='the_login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@class='text-shadow-white-3 border-0 cursor-pointer block flex items-center h-full px-3 text-center text-gray-800 bg-gray-gradient-100 lt:min-w-31 xs:hover:bg-white-200 xs:hover:bg-img-none']")
    public WebElement robinsAccount;

    @FindBy(xpath = "(//a[@class='hover:bg-green-25 block font-normal text-sm leading-snug py-1 px-5 text-gray-800 no-underline hover:no-underline whitespace-no-wrap'])[6]")
    public WebElement logout;


    public void loginWithValidCredentials(){

        accountClick.click();

        emailAddress.sendKeys(PropertyReader.getProperty("username"));
        password.sendKeys(PropertyReader.getProperty("password"));
        loginButton.click();
    }

}
