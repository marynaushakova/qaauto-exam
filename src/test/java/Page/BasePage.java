package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;

    /**
     * Parametrized waitUntilElementIsVisible method which implements confirmation of WebElement availability
     * @param webElement - input from test
     * @param timeOutInSeconds - input from test
     * @return value of variable with WebElement type
     */
    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
    /**
     * method getCurrentPageTitle
     * @return page title
     */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    /**
     * method getCurrentPageURL
     * @return page current URL
     */
    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }
    /**
     * method IsLoaded with abstract AccessModifier to be realized in Page Object with extends
     */
    public abstract boolean isLoaded();
}

