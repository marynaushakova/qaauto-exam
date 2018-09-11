package Test;

import Page.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    GooglePage googlePage;

    @BeforeMethod
    public void beforeMethod() {

        driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        googlePage = new GooglePage(driver);
        Assert.assertTrue(googlePage.isLoaded(), "Google page is not loaded!");
    }
    @AfterMethod
     public void afterMethod() {driver.close();
     }
}

//    public void beforeMethod(@Optional("Firefox") String browserName) {
// if (browserName.toLowerCase().equals("firefox")) {
//            driver = new FirefoxDriver();
//        }
//        if (browserName.toLowerCase().equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Temp\\chromedriver.exe");
//            driver = new ChromeDriver();
//        } else {
//            try {
//                throw new Exception("browserName " + browserName + " is  not supported");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
