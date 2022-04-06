package Steps;

import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsSteps extends BaseSteps {

    SearchResultsPage _searchResultsPage = new SearchResultsPage(_webDriver);

    public SearchResultsSteps(WebDriver _webDriver) {
        super(_webDriver);
    }

    public Boolean verifySearchResults() {
        WebElement yellowAlertWebElement = _searchResultsPage.getAlertResultsWebElements();
        return yellowAlertWebElement.isDisplayed(); //true or false
    }

    public void clearSearchTextBox() {
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        System.out.println("Limpiando Search TextBox");
        searchTextBox.clear();
        clickSearchButton();
    }

    public String getTextBoxValue() {
        //getAttribute
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        //Método para obtener un atributo HTML
        String value = searchTextBox.getAttribute("value");
        System.out.println("Obteniendo el atributo value del search text box: " + value);
        return value;
    }

    public void clickSearchButton() {
        WebElement searchButton = _searchResultsPage.getBtnSearch();
        System.out.println("Click en Search Button (lupa)");
        searchButton.click();
    }

    public void sendSearchText(String text) {
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        System.out.println("Enviando texto a search text box: " + text);
        searchTextBox.sendKeys(text);
    }

    public String getTotalResults() {
        WebElement textResults = _searchResultsPage.getTextResultsLabel();
        String totalTextResults = textResults.getText();
        return totalTextResults;
    }
}
