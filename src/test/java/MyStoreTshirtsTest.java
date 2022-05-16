import Steps.MyStoreTshirtsSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyStoreTshirtsTest extends BaseTest{
    private WebDriver _childWebDriver = webDriver;
    MyStoreTshirtsSteps tshirtsSteps = new MyStoreTshirtsSteps(_childWebDriver);


    @BeforeTest(description= "T-shirt category opens" ,groups = {"TshirtsCategoryTest"})
    public void setUp() {
        tshirtsSteps.openMyStore();
        tshirtsSteps.openTshirtsCategory();
    }

    @Test(description= "T-shirt URL is checked" , groups = {"TshirtsCategoryTest"})
    public void testURLCart() throws IOException {
        String cartURLActual = tshirtsSteps.getURLActual();
        Assert.assertEquals(cartURLActual, getPropertyValue("TSHIRT_CATEGORY_URL"),
                "Error: URL actual and expected do not match Tshirts category.");
    }

    @Test(description= "The banners is displayed" , groups = {"TshirtsCategoryTest"})
    public void testBannerDisplayed(){
        boolean result = tshirtsSteps.verifyBannerDisplayed();
        System.out.println("BannerDisplayed: " + result);
        Reporter.log("BannerDisplayed: " + result);
        Assert.assertTrue(result);
    }

    @Test(description= "The texts of the banners are validated" , groups = {"TshirtsCategoryTest"})
    public void testTextParragraphs() throws IOException {
        String first_P_actual = tshirtsSteps.getParagraphBanner(0);
        String second_P_actual = tshirtsSteps.getParagraphBanner(1);

        Assert.assertEquals(first_P_actual, getPropertyValue("FIRST_PARAGRAPH_BANNER_TSHIRT"));
        Assert.assertEquals(second_P_actual, getPropertyValue("SECOND_PARAGRAPH_BANNER_TSHIRT"));
    }

    @Test(description= "Content of the t-shirts list is displayed" , groups = {"TshirtsCategoryTest"})
    public void testParagraphCounter() throws IOException {
        String headerCounter = tshirtsSteps.getCounterParagraph();
        Assert.assertEquals(headerCounter, getPropertyValue("HEADER_COUNTER_TEXT_TSHIRTS"));
    }
}