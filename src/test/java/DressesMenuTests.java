import Steps.DressesMenuSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DressesMenuTests extends BaseTest {

    DressesMenuSteps dressesMenuSteps = new DressesMenuSteps(webDriver);

    @Test(description = "Dresses menu test.", groups = {"MenuTests"})
    public void testDressesMenu() throws IOException {

        dressesMenuSteps.openMyStore();
        dressesMenuSteps.clickDressesMenu();

        Assert.assertEquals(dressesMenuSteps.getCurrentDressesMenuURL(), getPropertyValue("EXPECTED_DRESSES_MENU_URL"));
        Assert.assertTrue(dressesMenuSteps.isDressesBannerDisplayed());
        Assert.assertEquals(dressesMenuSteps.getFirstDressesBannerText(), getPropertyValue("EXPECTED_FIRST_DRESSES_BANNER_TEXT"));
        Assert.assertEquals(dressesMenuSteps.getSecondDressesBannerText(), getPropertyValue("EXPECTED_SECOND_DRESSES_BANNER_TEXT"));
        Assert.assertEquals(dressesMenuSteps.getNumberOfDressesProductsText(), getPropertyValue("EXPECTED_NUMBER_OF_DRESSES_PRODUCTS_TEXT"));
    }
}
