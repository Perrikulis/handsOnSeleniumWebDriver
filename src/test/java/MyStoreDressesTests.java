import Steps.MyStoreDressesSteps;
import Steps.MyStoreHomeSteps;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyStoreDressesTests extends BaseTest{

    MyStoreDressesSteps myStoreDressesSteps = new MyStoreDressesSteps(webDriver);
    MyStoreHomeSteps myStoreHomeSteps = new MyStoreHomeSteps(webDriver);

    @Test(description = "Click and validate Dresses selection", groups = {"DressesCategoryTest"})
    public void testDressesURL() throws IOException {
        myStoreHomeSteps.clickOnDressesMenuItem();
        String dressesCategoryActualUrl = myStoreDressesSteps.getActualUrl();
        Reporter.log("Actual Url: " + dressesCategoryActualUrl + "<br>");
        System.out.println("Actual Url: " + dressesCategoryActualUrl);
        Reporter.log("Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL") + "<br>");
        System.out.println("Expected Url: " + getPropertyValue("DRESSES_MY_STORE_URL"));
        Assert.assertEquals(dressesCategoryActualUrl, getPropertyValue("DRESSES_MY_STORE_URL"),
                    "Error: URL actual and expected do not match.");
    }

    @Test(description = "Validate Title from Banner", groups = {"DressesCategoryTest"}, dependsOnMethods = "testDressesURL")
    public void testBannerDressesDisplayed(){
        boolean resultBannerDisplayed = myStoreDressesSteps.titleBannerIsDisplayed();
        Reporter.log("Dresses Banner Title is displayed: " + resultBannerDisplayed + "<br>");
        System.out.println("Dresses Banner Title is displayed: " + resultBannerDisplayed);
        Assert.assertTrue(resultBannerDisplayed, "Dresses Banner Tittle is not displayed");
    }

    @Test(groups = {"DressesCategoryTest"}, dependsOnMethods = "testBannerDressesDisplayed")
    public void testTextParagraphsDresses() throws IOException {
        String firstParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(0);
        String secondParagraphDressesActual = myStoreDressesSteps.getTextParagraphLine(1);
        Reporter.log("Actual line: " + firstParagraphDressesActual + "<br>");
        Reporter.log("Expected line: " + getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(firstParagraphDressesActual, getPropertyValue("FIRST_PARAGRAPH_DRESSES_BANNER"));
        Reporter.log("Actual line: " + secondParagraphDressesActual + "<br>");
        Reporter.log("Expected line: " + getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER") + "<br>");
        Assert.assertEquals(secondParagraphDressesActual, getPropertyValue("SECOND_PARAGRAPH_DRESSES_BANNER"));

    }

    @Test(groups = {"DressesCategoryTest"}, dependsOnMethods = "testTextParagraphsDresses")
    public void testParagraphCounter() throws IOException {
        String listResultsText = myStoreDressesSteps.getTextListResult();
        Reporter.log("Actual line: " + listResultsText + "<br>");
        System.out.println("Actual line: " + listResultsText);
        Reporter.log("Expected line: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT") + "<br>");
        System.out.println("Expected line: " + getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
        Assert.assertEquals(listResultsText, getPropertyValue("HEADER_COUNTER_DRESSES_TEXT"));
    }
}
