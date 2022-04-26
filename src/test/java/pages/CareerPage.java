package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CareerPage {




    public CareerPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(partialLinkText = "Careers")
    public WebElement careerPage;


    @FindBy(xpath = "//h2[@class=\"careers-positions__title pt-2\"]")
    public WebElement ActualJobs;


    @FindBy(id = "florida-filter-button")
    public WebElement StatePosition;

    @FindBy(xpath = "//button[@id=\"15-department\"]")
    public WebElement Dev;

    @FindBy(xpath = "//button[@class=\"careers-video__play-btn\"]")
    public WebElement Play;

    @FindBy(xpath = "//button[@class=\"ytp-large-play-button ytp-button\"]")
    public WebElement youTube;

    @FindBy(xpath = "//a[@class=\"ytp-title-link yt-uix-sessionlink\"]")
    public WebElement videoName;


    @FindBy(xpath = "//a[@href=\"/careers/department/development/44963/68873\"]")
    public WebElement firstPosition;

    @FindBy(xpath = "//a[@class=\"btn-fill\"]")
    public WebElement apply;

    @FindBy(id="FirstName")
    public WebElement firstName;

    @FindBy(id="LastName")
    public WebElement lastName;

    @FindBy(id="StreetPrimary")
    public WebElement address;

    @FindBy(id="StreetSecondary")
    public WebElement confirmAddress;

    @FindBy(name = "ZipCode")
    public WebElement zip;

    @FindBy(id="Email")
    public WebElement email;

    @FindBy(id="Phone")
    public WebElement phone;

    @FindBy(id="SelectedEducationLevelId")
    public WebElement education;

    @FindBy(id="AuthorizedToWorkInUnitedStatesYes")
    public WebElement yes;

    @FindBy(id="RequiresImmigrationCaseYes")
    public WebElement immigration;

    @FindBy(id="HasConvictionNo")
    public WebElement crime;

    @FindBy(id="SelectedReferralId")
    public WebElement referral;


    @FindBy(id="submit-button")
    public WebElement submit;









}
