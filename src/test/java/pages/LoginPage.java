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

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement logoutClick;


    public void loginWithValidCredentials(){

        accountClick.click();

        emailAddress.sendKeys(PropertyReader.getProperty("username"));
        password.sendKeys(PropertyReader.getProperty("password"));
        loginButton.click();
    }

}

