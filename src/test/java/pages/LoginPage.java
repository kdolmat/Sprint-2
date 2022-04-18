package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath="//a[@aria-label='login to your account']")
    public WebElement accountButton;

    @FindBy (xpath="//input[@id='email']")
    public WebElement username;

    @FindBy (xpath="//input[@id='password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='the_login_button']")
    public WebElement loginButton;


    public void absoluteLogin(){
        accountButton.click();
        username.sendKeys(ConfigReader.getProperty("username"));
        password.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();
    }

    public void newCredentials(){
        accountButton.click();
        username.sendKeys(ConfigReader.getProperty("invalidUsername"));
        password.sendKeys(ConfigReader.getProperty("invalidPassword"));
        loginButton.click();
    }









}
