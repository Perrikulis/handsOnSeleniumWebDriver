import Steps.SearchResultsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends BaseTest{

    SearchResultsSteps _searchResultsSteps = new SearchResultsSteps(webDriver);

    @Test
    public void testSearchTextBoxIsCleared() {
        _searchResultsSteps.openMyStore();
        String textToSearch = "dress"; // textToSearch: "dress"
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
            //Verify text box value is as String
            String currentSearchValue = _searchResultsSteps.getTextBoxValue();
            System.out.println("EL valor obtenido es: " + currentSearchValue);
            Assert.assertTrue(currentSearchValue.equals(stringSearch));
            //Clean search text box
            _searchResultsSteps.clearSearchTextBox();
        }
    }

    //Tarea 04 Abril
    //Obtener total de resultados

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
}
