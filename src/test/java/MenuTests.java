import Steps.MyStoreDressesSteps;
import Steps.MyStoreHomeSteps;
import Steps.MyStoreTshirtsSteps;
import Steps.MyStoreWomenSteps;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MenuTests extends BaseTest{


    MyStoreDressesSteps myStoreDressesSteps = new MyStoreDressesSteps(webDriver);
    MyStoreHomeSteps myStoreHomeSteps = new MyStoreHomeSteps(webDriver);
    MyStoreTshirtsSteps tshirtsSteps = new MyStoreTshirtsSteps(webDriver);
    MyStoreWomenSteps womenSteps = new MyStoreWomenSteps(webDriver);

    @Test(description = "Click and validate Dresses selection", groups = {"menuTestGroup"})
    public void testDressesCategory_SR1011() throws IOException {
        myStoreHomeSteps.clickOnDressesMenuItem();
        String dressesCategoryActualUrl = myStoreDressesSteps.getActualUrl();
        Reporter.log("Dresses Actual Url: " + dressesCategoryActualUrl + "<br>");
        System.out.println("Dresses Actual Url: " + dressesCategoryActualUrl);
        Reporter.log("Dresses Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL") + "<br>");
        System.out.println("Dresses Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL"));
        Assert.assertEquals(dressesCategoryActualUrl, getPropertyValue("DRESSES_MY_STORE_URL"),
                "Error: Dresses URL actual and expected do not match.");


        boolean resultBannerDisplayed = myStoreDressesSteps.titleBannerIsDisplayed();
        Reporter.log("Dresses menu is displayed: " + myStoreHomeSteps.dressesMenuItemIsDisplayed() + "<br>");
        Reporter.log("Dresses Banner Title is displayed: " + resultBannerDisplayed + "<br>");
        System.out.println("Dresses Banner Title is displayed: " + resultBannerDisplayed);
        Assert.assertTrue(resultBannerDisplayed, "Dresses Banner Tittle is not displayed");


        String firstParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(0);
        String secondParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(1);
        Reporter.log("Dresses Actual first line: " + firstParagraphDressesActual + "<br>");
        Reporter.log("Dresses Expected first line: " + getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(firstParagraphDressesActual, getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER"));
        Reporter.log("Dresses Actual second line: " + secondParagraphDressesActual + "<br>");
        Reporter.log("Dresses Expected second line: " + getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(secondParagraphDressesActual, getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER"));


        String listResultsText = myStoreDressesSteps.getTextListResult();
        Reporter.log("Actual dresses list result text: " + listResultsText + "<br>");
        System.out.println("Actual dresses list result text: " + listResultsText);
        Reporter.log("Expected dresses list result text: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT") + "<br>");
        System.out.println("Expected dresses list result text: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
        Assert.assertEquals(listResultsText, getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
    }


    //---------------------------------------





    @Test(description= "Click and validate T-shirt category" , groups = {"menuTestGroup"} )
    public void testTshirtCategory_SR1012() throws IOException {
        tshirtsSteps.openTshirtsCategory();
        String cartURLActual = tshirtsSteps.getURLActual();
        Reporter.log("TShirt Actual URL: " + cartURLActual + "<br>");
        Reporter.log("TShirt Expected URL: " + getPropertyValue("TSHIRT_CATEGORY_URL") + "<br>");
        Assert.assertEquals(cartURLActual, getPropertyValue("TSHIRT_CATEGORY_URL"),
                "Error: TShirt URL actual and expected do not match Tshirts category.");


        boolean result = tshirtsSteps.verifyBannerDisplayed();
        System.out.println("TShirt Banner is displayed: " + result);
        Reporter.log("TShirt Banner is displayed: " + result + "<br>");
        Assert.assertTrue(result);


        String first_P_actual = tshirtsSteps.getParagraphBanner(0);
        String second_P_actual = tshirtsSteps.getParagraphBanner(1);
        Reporter.log("Actual TShirt first paragraph: " + first_P_actual + "<br>");
        Reporter.log("Expected TShirt first paragraph: " + getPropertyValue("FIRST_PARAGRAPH_BANNER_TSHIRT") + "<br>");
        Assert.assertEquals(first_P_actual, getPropertyValue("FIRST_PARAGRAPH_BANNER_TSHIRT"));
        Reporter.log("Actual TShirt second paragraph: " + second_P_actual + "<br>");
        Reporter.log("Expected TShirt second paragraph: " + getPropertyValue("SECOND_PARAGRAPH_BANNER_TSHIRT") + "<br>");
        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER_TSHIRT"));

        String headerCounter = tshirtsSteps.getCounterParagraph();
        Reporter.log("Actual TShirt counter paragraph: " + headerCounter + "<br>");
        Reporter.log("Expected TShirt counter paragraph: " + getPropertyValue("HEADER_COUNTER_TEXT_TSHIRTS") + "<br>");
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT_TSHIRTS"));
    }


    //----------------------------------------


    @Test(description = "Click and validate Women category", groups = {"menuTestGroup"})
    public void testWomenCategory_SR1010() throws IOException {
        womenSteps.openWomenCategory();
        String cartURLActual = womenSteps.getURLActual();
        Assert.assertEquals(cartURLActual, getPropertyValue("WOMEN_CATEGORY_URL"),
                "Error: Women URL actual and expected do not match.");
        Reporter.log("Women Actual URL: " + cartURLActual + "<br>");
        Reporter.log("Women Expected URL: " + getPropertyValue("WOMEN_CATEGORY_URL") + "<br>");

        boolean result = womenSteps.verifyBannerDisplayed();
        System.out.println("Women Banner is displayed: " + result);
        Reporter.log("Women Banner is displayed: " + result+ "<br>");
        Assert.assertTrue(result);


        String second_P_actual = womenSteps.getParagraphBanner(1);
        Reporter.log("Second paragraph Women actual: " + second_P_actual + "<br>");
        Reporter.log("Second paragraph Women expected: " + getPropertyValue("SECOND_PARAGRAPH_BANNER") + "<br>");

        String third_P_actual = womenSteps.getParagraphBanner(2);
        Reporter.log("Third paragraph Women actual: " + third_P_actual + "<br>");
        Reporter.log("Third paragraph Women expected: " + getPropertyValue("THIRD_PARAGRAPH_BANNER") + "<br>");

        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER"));
        Assert.assertEquals(third_P_actual, getPropertyValue("THIRD_PARAGRAPH_BANNER"));

        String headerCounter = womenSteps.getCounterParagraph();
        Reporter.log("Women Text counter actual: " + headerCounter + "<br>");
        Reporter.log("Women Text counter expected: " + getPropertyValue("HEADER_COUNTER_TEXT"));
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT"));
    }
}
