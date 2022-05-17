import Steps.DressesBannerSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DressesBannerTest extends BaseTest {

    DressesBannerSteps dressesBannerSteps = new DressesBannerSteps(webDriver);

    @Test(description = "Test de el contenido del banner del la opción Dresses",groups = {"dressesTest"})
    public void testDressesMenu() throws IOException {

        dressesBannerSteps.openMyStore();
        dressesBannerSteps.clickDressesBtn();

        Assert.assertEquals(dressesBannerSteps.getCurrentDressesMenuURL(),getPropertyValue("EXPECTED_DRESSES_MENU_URL"));
        Assert.assertTrue(dressesBannerSteps.isDressesBannerDisplayed());
        Assert.assertEquals(dressesBannerSteps.getFirstDressesBannerText(),getPropertyValue("EXPECTED_FIRST_DRESSES_BANNER_TEXT"));
        Assert.assertEquals(dressesBannerSteps.getSecondDressesBannerText(),getPropertyValue("EXPECTED_SECOND_DRESSES_BANNER_TEXT"));
        Assert.assertEquals(dressesBannerSteps.getNumberOfDressesProductsText(),getPropertyValue("EXPECTED_NUMBER_OF_DRESSES_PRODUCTS_TEXT"));
    }
}
