package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    @FindBy(xpath = "//a[@class='gb_P']")
    private WebElement linkToGmail;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(linkToGmail, 10);
    }

    public FirstSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return  new FirstSearchResultsPage(driver);
        }

        public boolean isLoaded () {
            return linkToGmail.isDisplayed()
                    && getCurrentPageURL().equals("https://www.google.com/")
                    && getCurrentPageTitle().equals("Google");
        }

}
