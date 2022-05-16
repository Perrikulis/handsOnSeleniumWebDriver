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
        Reporter.log("Actual Url: " + dressesCategoryActualUrl + "<br>");
        System.out.println("Actual Url: " + dressesCategoryActualUrl);
        Reporter.log("Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL") + "<br>");
        System.out.println("Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL"));
        Assert.assertEquals(dressesCategoryActualUrl, getPropertyValue("DRESSES_MY_STORE_URL"),
                "Error: URL actual and expected do not match.");


        boolean resultBannerDisplayed = myStoreDressesSteps.titleBannerIsDisplayed();
        Reporter.log("Dresses menu is displayed: " + myStoreHomeSteps.dressesMenuItemIsDisplayed() + "<br>");
        Reporter.log("Dresses Banner Title is displayed: " + resultBannerDisplayed + "<br>");
        System.out.println("Dresses Banner Title is displayed: " + resultBannerDisplayed);
        Assert.assertTrue(resultBannerDisplayed, "Dresses Banner Tittle is not displayed");


        String firstParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(0);
        String secondParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(1);
        Reporter.log("Actual line: " + firstParagraphDressesActual + "<br>");
        Reporter.log("Expected line: " + getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(firstParagraphDressesActual, getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER"));
        Reporter.log("Actual line: " + secondParagraphDressesActual + "<br>");
        Reporter.log("Expected line: " + getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(secondParagraphDressesActual, getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER"));


        String listResultsText = myStoreDressesSteps.getTextListResult();
        Reporter.log("Actual line: " + listResultsText + "<br>");
        System.out.println("Actual line: " + listResultsText);
        Reporter.log("Expected line: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT") + "<br>");
        System.out.println("Expected line: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
        Assert.assertEquals(listResultsText, getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
    }


    //---------------------------------------





    @Test(description= "Click and validate T-shirt category" , groups = {"menuTestGroup"} )
    public void testTshirtCategory_SR1012() throws IOException {
        tshirtsSteps.openTshirtsCategory();
        String cartURLActual = tshirtsSteps.getURLActual();
        Assert.assertEquals(cartURLActual, getPropertyValue("TSHIRT_CATEGORY_URL"),
                "Error: URL actual and expected do not match Tshirts category.");


        boolean result = tshirtsSteps.verifyBannerDisplayed();
        System.out.println("BannerDisplayed: " + result);
        Reporter.log("BannerDisplayed: " + result);
        Assert.assertTrue(result);


        String first_P_actual = tshirtsSteps.getParagraphBanner(0);
        String second_P_actual = tshirtsSteps.getParagraphBanner(1);

        Assert.assertEquals(first_P_actual, getPropertyValue("FIRST_PARAGRAPH_BANNER_TSHIRT"));
        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER_TSHIRT"));


        String headerCounter = tshirtsSteps.getCounterParagraph();
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT_TSHIRTS"));
    }


    //----------------------------------------


    @Test(description = "Click and validate Women category", groups = {"menuTestGroup"})
    public void testWomenCategory_SR1010() throws IOException {
        womenSteps.openWomenCategory();
        String cartURLActual = womenSteps.getURLActual();
        Assert.assertEquals(cartURLActual, getPropertyValue("WOMEN_CATEGORY_URL"),
                "Error: URL actual and expected do not match.");
        Reporter.log("Actual URL: " + cartURLActual + "<br>");
        Reporter.log("Expected URL: " + getPropertyValue("WOMEN_CATEGORY_URL") + "<br>");

        boolean result = womenSteps.verifyBannerDisplayed();
        System.out.println("BannerDisplayed: " + result);
        Reporter.log("BannerDisplayed: " + result+ "<br>");
        Assert.assertTrue(result);


        String second_P_actual = womenSteps.getParagraphBanner(1);
        Reporter.log("Second paragraph actual: " + second_P_actual + "<br>");
        Reporter.log("Second paragraph expected: " + getPropertyValue("SECOND_PARAGRAPH_BANNER") + "<br>");

        String third_P_actual = womenSteps.getParagraphBanner(2);
        Reporter.log("Third paragraph actual: " + third_P_actual + "<br>");
        Reporter.log("Third paragraph expected: " + getPropertyValue("THIRD_PARAGRAPH_BANNER") + "<br>");

        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER"));
        Assert.assertEquals(third_P_actual, getPropertyValue("THIRD_PARAGRAPH_BANNER"));

        String headerCounter = womenSteps.getCounterParagraph();
        Reporter.log("Text counter actual: " + headerCounter + "<br>");
        Reporter.log("Text counter expected: " + getPropertyValue("HEADER_COUNTER_TEXT"));
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT"));
    }
}
