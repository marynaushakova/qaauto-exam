package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SecondSearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@id=\"resultStats\"]")
    private WebElement resultStats;

    @FindBy(xpath = "//h3[contains(@class, 'r')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//td[@class='cur']")
    private WebElement currentResultPageNumber;

    public SecondSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsVisible(resultStats, 10);
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
    public String getCurrentResultPageNumber(){
        return currentResultPageNumber.getText();
    }
    public boolean isLoaded() {
        return currentResultPageNumber.isDisplayed();
    }
}
