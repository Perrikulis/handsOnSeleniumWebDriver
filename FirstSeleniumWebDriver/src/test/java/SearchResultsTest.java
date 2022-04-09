import Steps.SearchResultsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SearchResultsTest extends BaseTest {
    SearchResultsSteps _searchResultSteps = new SearchResultsSteps(webDriver);

    @Test
    public void testSearchTextBosIsCleared() {
        _searchResultSteps.openMyStore();
        String textToSearch = "dress";
        //Step 1 : send text to search textbox
        _searchResultSteps.sendSearchText(textToSearch);
        //Step 2 : click search button
        _searchResultSteps.clickSearchButton();
        //Step 3 : verify value is in textbox
        String textBoxValue = _searchResultSteps.getTextBoxValue();
        //step 4: clear textbox
        _searchResultSteps.clearSearchTextBox();
        //Step 5: verigy textbox is clear
        textBoxValue = _searchResultSteps.getTextBoxValue();

    }

    @Test
    public void testMultipleSearch() {
        //List of strings to search: blouse, shirt, dress
        List<String> searchTerms = Arrays.asList("blouse", "shirt", "dress");
        //String[] searchTerms1 = new String[] {"blouse", "shirt", "dress"};

        _searchResultSteps.openMyStore();

        for (String term : searchTerms) {
            //Send String to search text box
            _searchResultSteps.sendSearchText(term);
            //Click search button
            _searchResultSteps.clickSearchButton();
            //Verify text box value is as String

            String currentSearchValue = _searchResultSteps.getTextBoxValue();
            System.out.println("El valor del text box de busqueda es: " + currentSearchValue);
            Assert.assertEquals(currentSearchValue, term);
            _searchResultSteps.clearSearchTextBox();
        }
    }

    //Tarea 04 abril 2022
    //Obtener total de resultados (WebElement)
}
