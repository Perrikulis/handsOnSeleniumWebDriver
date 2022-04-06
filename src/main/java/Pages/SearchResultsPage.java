package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Este tipo de clase POM (Page Object Model) sooo debe regresar elementos web para que la clase Steps los pueda utilizar
public class SearchResultsPage{

    WebDriver _webDriverResults;
    final String alertSearchCSSLocator = "div#center_column > .alert";
    final String searchTextBoxCSSLocator = "div > form#searchbox";
    final String searchTextBoxIdLocator = "search_query_top";
    final String buttonSearchCSSLocator = "form#searchbox > button";
    final String resultsTextCSSLocator = "h1 > .heading-counter";

    //Constructor receives WebDriver object type
    public SearchResultsPage(WebDriver _webDriverResults) {
        this._webDriverResults = _webDriverResults;
    }

    public WebElement getAlertResultsWebElements() {
        WebElement alertResults = _webDriverResults.findElement(By.cssSelector(alertSearchCSSLocator));
        return alertResults;
    }

    public WebElement getSearchTextBox() {
        WebElement searchTextBox = _webDriverResults.findElement(By.id(searchTextBoxIdLocator));
        return searchTextBox;
    }

    public WebElement getBtnSearch() {
        WebElement searchButton = _webDriverResults.findElement(By.cssSelector(buttonSearchCSSLocator));
        return searchButton;
    }

    public WebElement getTextResultsLabel() {
        WebElement textResults = _webDriverResults.findElement(By.cssSelector(resultsTextCSSLocator));
        return textResults;
    }
}
