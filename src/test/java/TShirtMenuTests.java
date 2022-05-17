import Steps.TShirtMenuSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TShirtMenuTests extends BaseTest {

    TShirtMenuSteps tShirtMenuSteps = new TShirtMenuSteps(webDriver);

    @Test(description = "TShirt menu test.", groups = {"MenuTests"})
    public void testDressesMenu() throws IOException {

        tShirtMenuSteps.openMyStore();
        tShirtMenuSteps.clickTShirtMenu();

        Assert.assertEquals(tShirtMenuSteps.getCurrentTShirtMenuURL(), getPropertyValue("EXPECTED_TSHIRT_MENU_URL"));
        Assert.assertTrue(tShirtMenuSteps.isTShirtBannerDisplayed());
        Assert.assertEquals(tShirtMenuSteps.getFirstTShirtBannerText(), getPropertyValue("EXPECTED_FIRST_TSHIRT_BANNER_TEXT"));
        Assert.assertEquals(tShirtMenuSteps.getSecondTShirtBannerText(), getPropertyValue("EXPECTED_SECOND_TSHIRT_BANNER_TEXT"));
        Assert.assertEquals(tShirtMenuSteps.getNumberOfTShirtProductsText(), getPropertyValue("EXPECTED_NUMBER_OF_TSHIRT_PRODUCTS_TEXT"));
    }
}
