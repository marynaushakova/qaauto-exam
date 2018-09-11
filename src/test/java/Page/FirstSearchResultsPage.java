package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FirstSearchResultsPage extends BasePage{

    @FindBy(xpath = "//a[@id='logo']")
    private WebElement resultStats;

    @FindBy(xpath = "//td[@class=\"cur\"]")
    private WebElement currentResultPageNumber;

    @FindBy(xpath = "//a[@aria-label=\"Page 2\"]")
    private WebElement secondResultPageLink;

    @FindBy(xpath = "//h3[contains(@class, 'r')]")
    private List<WebElement> searchResults;


    public FirstSearchResultsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(resultStats, 20);
    }

    public SecondSearchResultsPage goToSecondResultPage () {
        secondResultPageLink.click();
    return new SecondSearchResultsPage(driver);

    }
    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultsList.add(searchResult.getText());
        }
        return searchResultsList;
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }
    public boolean isLoaded() {
        return resultStats.isDisplayed();
               // &&getCurrentPageURL().contains("/search?q=");
    }
}
