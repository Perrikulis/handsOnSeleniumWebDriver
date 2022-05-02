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

    public String getTotalResults() {
        WebElement textResults = _searchResultsPage.getTextResultsLabel();
        String totalTextResults = textResults.getText();
        return totalTextResults;
    }

    public void clickMenuOption(int indexOption){
        _searchResultsPage.getMenuCategory().get(indexOption).click();
    }

    public String getTextNameBanner(){
        WebElement bannerTextObject = _searchResultsPage.getNameTextBanner();
        String value = bannerTextObject.getText();
        System.out.println("El texto del nombre del banner es: " + value);
        return value;
    }

    public String getTextSearchIntoBanner(int index){
        String textIntoBanner = _searchResultsPage.getTextFromBanner().get(index).getText();
        return textIntoBanner;
    }

    public String getTextSearchResult(){
        String textSearchResultWomen = _searchResultsPage.getTextNumberProducts().getText();
        return textSearchResultWomen;
    }

}
