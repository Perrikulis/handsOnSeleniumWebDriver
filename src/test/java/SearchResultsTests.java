import Steps.SearchResultsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.util.resources.cldr.sv.CalendarData_sv_SE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResultsTests extends BaseTest {
    SearchResultsSteps _searchResultsSteps = new SearchResultsSteps(webDriver);

    @Test
    public void testSearchTextBoxIsCleared() {
        _searchResultsSteps.openMyStore();
        String textToSearch = "dress";
        //Step 1: Send text to search textbox
        _searchResultsSteps.sendSearchText(textToSearch);
        //Step 2: Click search button
        _searchResultsSteps.clickSearchButton();
        //Step 3: Verify value is in textbox
        String textBoxValue = _searchResultsSteps.getTextBoxValue();
        //Step 4: Clear textbox
        _searchResultsSteps.clearSearchTextBox();
        //Step 5: Verify textbox is clear
        textBoxValue = _searchResultsSteps.getTextBoxValue();
    }

    @Test
    public void testMultipleSearch() {
        //List of strings to search: blouse, shirt, dress
        List<String> searchTerms = Arrays.asList("blouse", "shirt", "dress");
        //String[] searchTerms1 = new String[] {"blouse", "shirt", "dress"};

        _searchResultsSteps.openMyStore();

        for (String term : searchTerms) {
            //Send String to search text box
            _searchResultsSteps.sendSearchText(term);
            //Click search button
            _searchResultsSteps.clickSearchButton();
            //Verify text box value is as String
            String currentSearchValue = _searchResultsSteps.getTextBoxValue();
            System.out.println("El valor del text box de busqueda es: " + currentSearchValue);
            Assert.assertEquals(currentSearchValue, term);
            _searchResultsSteps.clearSearchTextBox();
        }
    }

    //Tarea 04 abril 2022
    //Obtener total de resultados (WebElement)

    @Test
    public void testResultsTextLabel() {
        _searchResultsSteps.openMyStore();
        //List  of string to search: blouse, shirt, dress
        String[] listString = {"blouse", "shirt", "dress"};
        //String 1:
        for (String stringSearch: listString
        ) {
            //Send String to search text box
            _searchResultsSteps.sendSearchText(stringSearch);
            //Click search button
            _searchResultsSteps.clickSearchButton();
            //Get total results
            String totalResults = _searchResultsSteps.getTotalResults();
            System.out.println(totalResults);
            //Clean search text box
            _searchResultsSteps.clearSearchTextBox();
        }
    }

    @Test
    public void testWomenBanner(){
        String _URLExpected = "http://automationpractice.com/index.php?id_category=3&controller=category";
        String _textBanner1Expected = "This category includes all the basics of your wardrobe and much more:";
        String _textBanner2Expected = "shoes, accessories, printed t-shirts, feminine dresses, women's jeans!";
        String _textSearchResultBanner = "There are 7 products.";
        String _nameBannerExpected = "Women";
        _searchResultsSteps.openMyStore();
        _searchResultsSteps.clickMenuOption(0);
        String URLActual = webDriver.getCurrentUrl();
        System.out.println("La URL actual es: " + URLActual);
        Assert.assertEquals(_URLExpected, URLActual, "La URL actual es diferente a la URL esperada" );
        String nameBannerActual = _searchResultsSteps.getTextNameBanner();
        Assert.assertEquals(_nameBannerExpected, nameBannerActual, "El nombre del banner actual es diferente del nombre esperado");
        String textBanner1Actual = _searchResultsSteps.getTextSearchIntoBanner(1);
        Assert.assertEquals(_textBanner1Expected, textBanner1Actual, "Texto 1 de banner actual es diferente al texto del banner esperado");
        String textBanner2Actual = _searchResultsSteps.getTextSearchIntoBanner(2);
        Assert.assertEquals(_textBanner2Expected, textBanner2Actual, "Texto 2 de banner actual es diferente al texto del banner esperado");
        String textSearchResultWomen = _searchResultsSteps.getTextSearchResult();
        Assert.assertEquals(_textSearchResultBanner, textSearchResultWomen, "El texto de la búsqueda mostrado actualmente es diferente al esperado");
    }
}
