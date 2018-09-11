package Test;

import Page.FirstSearchResultsPage;
import Page.GooglePage;
import Page.SecondSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest{

    @Test
    public  void seleniumSearchInGoogle (){
        FirstSearchResultsPage firstSearchResultsPage= googlePage.search("Selenium");
        Assert.assertTrue(firstSearchResultsPage.isLoaded(), "First search page is not loaded!");
        Assert.assertEquals(firstSearchResultsPage.getSearchResultsCount(), 10, "Search results count is wrong");

        List<String> searchResults = firstSearchResultsPage.getSearchResultsList();
        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains("selenium"), "searchTerm is not found in : \n" + searchResult);
        }
        SecondSearchResultsPage secondSearchResultsPage = firstSearchResultsPage.goToSecondResultPage();
        Assert.assertEquals(secondSearchResultsPage.getCurrentResultPageNumber(), "2","Second search page is not loaded!");
        Assert.assertEquals(secondSearchResultsPage.getSearchResultsCount(), 10, "Search results count is wrong");

        List<String> searchResultsOnSecondPage = secondSearchResultsPage.getSearchResultsList();
        for (String searchResult : searchResultsOnSecondPage) {
            Assert.assertTrue(searchResult.toLowerCase().contains("selenium"), "searchTerm is not found on second page in : \n" + searchResult);
        }
    }
}
