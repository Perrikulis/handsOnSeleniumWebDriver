import Steps.SearchResultsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Test
    public void testHeadingCounter() {
        _searchResultsSteps.openMyStore();

        Map<String, Integer> mapToSearch = new HashMap<>();
        mapToSearch.put("blouse", 1);
        mapToSearch.put("shirt", 1);
        mapToSearch.put("dress", 7);
        String commonTextSingular = " result has been found.";
        String commonTexPlural = " results have been found.";
        mapToSearch.forEach((key, value)->{
            _searchResultsSteps.sendSearchText(key);
            _searchResultsSteps.clickSearchButton();
            String textBoxValue = _searchResultsSteps.getTextCounter();
            String expectedValue = "";
            if(value>1) {
                expectedValue = value + commonTexPlural;
            }else{
                expectedValue = value + commonTextSingular;
            }
            Assert.assertEquals(expectedValue, textBoxValue);
            _searchResultsSteps.clearSearchTextBox();
        });

    }
}
