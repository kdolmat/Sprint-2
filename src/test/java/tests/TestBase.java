package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyReader;
import utilities.Driver;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    public String title = PropertyReader.getProperty("title");





    @BeforeMethod
    public void setupMethod(Method method){


        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(PropertyReader.getProperty("url"));
       // logger = report.createTest(method.getName());
    }


    @AfterMethod
    public void tearDownMethod(ITestResult testResult){

        Driver.quitDriver();
    }


}
