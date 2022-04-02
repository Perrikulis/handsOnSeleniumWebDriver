import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    WebDriver _webDriverResults;
    final String alertSearchResultsCSSLocator = "div#center_column > .alert";

    public SearchResultsPage(WebDriver _webDriverResults) {
        this._webDriverResults = _webDriverResults;
    }

    public Boolean verifySearchResults() {
        WebElement alertResults = _webDriverResults.findElement(By.cssSelector(alertSearchResultsCSSLocator));
        return alertResults.isDisplayed();
    }
}
