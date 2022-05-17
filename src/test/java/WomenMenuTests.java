import Steps.WomenMenuSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WomenMenuTests extends BaseTest {

    WomenMenuSteps womenMenuSteps = new WomenMenuSteps(webDriver);

    @Test(description = "Women menu test.", groups = {"MenuTests"})
    public void testWomenMenu() throws IOException {

        womenMenuSteps.openMyStore();
        womenMenuSteps.clickWomenMenu();

        Assert.assertEquals(womenMenuSteps.getCurrentWomenMenuURL(), getPropertyValue("EXPECTED_WOMEN_MENU_URL"));
        Assert.assertTrue(womenMenuSteps.isWomenBannerDisplayed());
        Assert.assertEquals(womenMenuSteps.getFirstWomenBannerText(), getPropertyValue("EXPECTED_FIRST_WOMAN_BANNER_TEXT"));
        Assert.assertEquals(womenMenuSteps.getSecondWomenBannerText(), getPropertyValue("EXPECTED_SECOND_WOMAN_BANNER_TEXT"));
        Assert.assertEquals(womenMenuSteps.getNumberOfWomenProductsText(), getPropertyValue("EXPECTED_NUMBER_OF_WOMEN_PRODUCTS_TEXT"));
    }
}
