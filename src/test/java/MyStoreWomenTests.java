import Steps.MyStoreWomenSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MyStoreWomenTests extends BaseTest{
    private WebDriver _childWebDriver = webDriver;
    MyStoreWomenSteps womenSteps = new MyStoreWomenSteps(_childWebDriver);

    private final String womenCategorySelector = "#block_top_menu ul li a[title='Women']";

    private final static String WOMEN_CATEGORY_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    private final static String HEADER_COUNTER_TEXT = "There are 7 products.";
    private final static String FIRST_PARAGRAPH_BANNER = "You will find here all woman fashion collections.";
    private final static String SECOND_PARAGRAPH_BANNER = "This category includes all the basics of your wardrobe and much more:";
    private final static String THIRD_PARAGRAPH_BANNER = "shoes, accessories, printed t-shirts, feminine dresses, women's jeans!";

    @BeforeMethod
    public void setUp() {
        womenSteps.openMyStore();
        womenSteps.openWomenCategory();
    }

    @Test
    public void testURLCart() {
        String cartURLActual = womenSteps.getURLActual();
        Assert.assertEquals(cartURLActual, WOMEN_CATEGORY_URL,
                "Error: URL actual and expected do not match.");
    }

    @Test
    public void testBannerDisplayed(){
        boolean result = womenSteps.verifyBannerDisplayed();
        System.out.println("BannerDisplayed: " + result);
        Assert.assertTrue(result);
    }

    @Test
    public void testTextParragraphs(){
        String first_P_actual = womenSteps.getParagraphBanner(0);
        String second_P_actual = womenSteps.getParagraphBanner(1);
        String third_P_actual = womenSteps.getParagraphBanner(2);

        Assert.assertEquals(first_P_actual, FIRST_PARAGRAPH_BANNER);
        Assert.assertEquals(second_P_actual, SECOND_PARAGRAPH_BANNER);
        Assert.assertEquals(third_P_actual, THIRD_PARAGRAPH_BANNER);
    }

    @Test
    public void testParagraphCounter() {
        String headerCounter = womenSteps.getCounterParagraph();
        Assert.assertEquals(headerCounter, HEADER_COUNTER_TEXT);
    }
}
