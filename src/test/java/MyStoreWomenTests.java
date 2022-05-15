import Steps.MyStoreWomenSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class MyStoreWomenTests extends BaseTest{
    private WebDriver _childWebDriver = webDriver;
    MyStoreWomenSteps womenSteps = new MyStoreWomenSteps(_childWebDriver);

    private final String womenCategorySelector = "#block_top_menu ul li a[title='Women']";



    @BeforeTest(groups = {"WomenCategoryTest"})
    public void setUp() {
        womenSteps.openMyStore();
        womenSteps.openWomenCategory();
    }

    @Test(groups = {"WomenCategoryTest"})
    public void testURLCart() throws IOException {
        String cartURLActual = womenSteps.getURLActual();
        Assert.assertEquals(cartURLActual, getPropertyValue("WOMEN_CATEGORY_URL"),
                "Error: URL actual and expected do not match.");
    }

    @Test(groups = {"WomenCategoryTest"})
    public void testBannerDisplayed(){
        boolean result = womenSteps.verifyBannerDisplayed();
        System.out.println("BannerDisplayed: " + result);
        Reporter.log("BannerDisplayed: " + result);
        Assert.assertTrue(result);
    }

    @Test(groups = {"WomenCategoryTest"})
    public void testTextParragraphs() throws IOException {
        String first_P_actual = womenSteps.getParagraphBanner(0);
        String second_P_actual = womenSteps.getParagraphBanner(1);
        String third_P_actual = womenSteps.getParagraphBanner(2);

        Assert.assertEquals(first_P_actual, getPropertyValue("FIRST_PARAGRAPH_BANNER"));
        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER"));
        Assert.assertEquals(third_P_actual, getPropertyValue("THIRD_PARAGRAPH_BANNER"));
    }

    @Test(groups = {"WomenCategoryTest"})
    public void testParagraphCounter() throws IOException {
        String headerCounter = womenSteps.getCounterParagraph();
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT"));
    }
}