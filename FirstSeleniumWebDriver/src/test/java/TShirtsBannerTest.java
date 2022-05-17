import Pages.TShirtsBannerPage;
import Pages.WomenBannerPage;
import Steps.TShirtBannerSteps;
import Steps.WomenBannerSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TShirtsBannerTest extends BaseTest {

    TShirtsBannerPage tShirtsBannerPage = new TShirtsBannerPage(webDriver);
    TShirtBannerSteps tShirtBannerSteps = new TShirtBannerSteps(webDriver);

    //Btn Women Options
    @Test(description = "Test de el contenido del banner del la opción T-Shirts",groups = {"tShirtsTest"})
    public void womenBtnCLick() throws IOException {
        tShirtBannerSteps.openMyStore();
        tShirtBannerSteps.clickTshirtBtn();
        tShirtBannerSteps.getCurrentTShirtMenuURL();
        System.out.println("La URL actual es: " + tShirtBannerSteps.getCurrentTShirtMenuURL());
        Assert.assertEquals(tShirtBannerSteps.getCurrentTShirtMenuURL(),getPropertyValue("EXPECTED_TSHIRTS_MENU_URL"));

        Assert.assertTrue(tShirtBannerSteps.isTShirtBannerDisplayed());

        Assert.assertEquals(tShirtBannerSteps.getFirstTShirtBannerText(),getPropertyValue("EXPECTED_FIRST_TSHIRTS_BANNER_TEXT"));
        Assert.assertEquals(tShirtBannerSteps.getSecondTShirtBannerText(),getPropertyValue("EXPECTED_SECOND_TSHIRTS_BANNER_TEXT"));

        Assert.assertEquals(tShirtBannerSteps.getNumberOfTShirtProductsText(),getPropertyValue("EXPECTED_NUMBER_OF_TSHIRTS_PRODUCTS_TEXT"));


    }
}
