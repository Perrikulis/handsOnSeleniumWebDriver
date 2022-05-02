package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//Este tipo de clase POM (Page Object Model) solo debe regresar elementos web para que la clase Steps los pueda utilizar
public class SearchResultsPage {
    WebDriver _webDriverResults;
    final String alertSearchResultsCSSLocator = "div#center_column > .alert";
    final String searchTextBoxIdLocator = "search_query_top";
    final String btnSearchCSSLocator = "form#searchbox > button";
    final String resultsTextCSSLocator = "h1 > .heading-counter";
    final String menuCategoryCSSLocator = ".sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li";
    final String textNameBannerCSSLocator = ".cat_desc > span";
    final String textSearchInBannerCSSLocator = ".rte > p";
    final String textNumberProductsCSSLocator = ".page-heading.product-listing > .heading-counter";

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

    public WebElement getBtnSearch() {
        return _webDriverResults.findElement(By.cssSelector(btnSearchCSSLocator));
    }

    public WebElement getTextResultsLabel() {
        WebElement textResults = _webDriverResults.findElement(By.cssSelector(resultsTextCSSLocator));
        return textResults;
    }

    public List<WebElement> getMenuCategory(){
        List<WebElement> menuCategory = _webDriverResults.findElements(By.cssSelector(menuCategoryCSSLocator));
        return menuCategory;
    }

    public List<WebElement> getTextFromBanner(){
        List<WebElement> objectBanner = _webDriverResults.findElements(By.cssSelector(textSearchInBannerCSSLocator));
        return objectBanner;
    }

    public WebElement getNameTextBanner(){
        WebElement textNameBanner = _webDriverResults.findElement(By.cssSelector(textNameBannerCSSLocator));
        return textNameBanner;
    }

    public WebElement getTextNumberProducts(){
        WebElement textNumberProducts = _webDriverResults.findElement(By.cssSelector(textNumberProductsCSSLocator));
        return textNumberProducts;
    }

}
