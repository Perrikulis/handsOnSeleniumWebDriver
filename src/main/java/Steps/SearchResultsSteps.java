package Steps;

import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsSteps extends BaseSteps {
    SearchResultsPage _searchResultsPage = new SearchResultsPage(_webDriver);

    public SearchResultsSteps(WebDriver _webDriver) {
        super(_webDriver);
        System.out.println("Constructor en SearchResultsSteps.java");
    }

    public Boolean verifySearchResults() {
        System.out.println("Metodo verifySearchResults en SearchResultsSteps.java");
        WebElement yellowAlertWebElement = _searchResultsPage.getAlertResultsWebElement();
        return yellowAlertWebElement.isDisplayed();//true or false
    }

    public void clearSearchTextBox() {
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        System.out.println("Limpiando Search text box");
        searchTextBox.clear();
        clickSearchButton();
    }

    public String getTextBoxValue() {
        //getAttribute
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        //Metodo para obtener un atributo del HTML
        String value = searchTextBox.getAttribute("value");
        System.out.println("Obteniendo el atributo value del search text box: " + value);
        return value;
    }

    public void clickSearchButton() {
        WebElement searchButton = _searchResultsPage.getBtnSearch();
        System.out.println("Clic en Search button (lupa)");
        searchButton.click();
    }

    public void sendSearchText(String text) {
        WebElement searchTextBox = _searchResultsPage.getSearchTextBox();
        System.out.println("Enviando texto a search text box: " + text);
        searchTextBox.sendKeys(text);
    }
}
