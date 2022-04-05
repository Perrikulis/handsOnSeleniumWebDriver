import Steps.SearchResultsSteps;
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
}
