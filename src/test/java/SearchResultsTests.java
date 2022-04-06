import Steps.SearchResultsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SearchResultsTests extends BaseTest{
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
    public void testMultipleSearch(){
        _searchResultsSteps.openMyStore();

        List<String> items = Arrays.asList("blouse", "shirt", "dress");
        for (String item: items) {
            _searchResultsSteps.sendSearchText(item);
            _searchResultsSteps.clickSearchButton();
            String textBoxValue = _searchResultsSteps.getTextBoxValue();
            Assert.assertEquals(textBoxValue, item);
            _searchResultsSteps.clearSearchTextBox();
        }

    }

    //En la seccion de busqeudas vamos a obtener el primer resultado
    //Cantidad de resultados
}
