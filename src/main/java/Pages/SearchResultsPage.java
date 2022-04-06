package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Este tipo de clase POM (Page Object Model) solo debe regresar elementos web para que la clase Steps los pueda utilizar
public class SearchResultsPage {
    WebDriver _webDriverResults;
    final String alertSearchResultsCSSLocator = "div#center_column > .alert";
    final String searchTextBoxIdLocator = "search_query_top";
    final String btnSearchCSSLocator = "form#searchbox > button";
    final String spanHeadingCounter = "span.heading-counter";

    //Constructor receives WebDriver object type
    public SearchResultsPage(WebDriver _webDriverResults) {
        System.out.println("Constructor SearchResultsPage.java");
        this._webDriverResults = _webDriverResults;
    }

    public WebElement getAlertResultsWebElement() {
        System.out.println("Metodo getAlertResultsWebElement en SearchResultsPage.java");
        WebElement alertResults = _webDriverResults.findElement(By.cssSelector(alertSearchResultsCSSLocator));
        return alertResults;
    }

    public WebElement getSearchTextBox() {
        WebElement searchTextBox = _webDriverResults.findElement(By.id(searchTextBoxIdLocator));
        return searchTextBox;
    }

    public WebElement getHeadingCounter(){
        return _webDriverResults.findElement(By.cssSelector(spanHeadingCounter));
    }

    public WebElement getBtnSearch() {
        return _webDriverResults.findElement(By.cssSelector(btnSearchCSSLocator));
    }
}
