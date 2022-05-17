import Pages.WomenBannerPage;
import Steps.WomenBannerSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WomenBannerTest extends BaseTest {

    WomenBannerPage womenBannerPage = new WomenBannerPage(webDriver);
    WomenBannerSteps womenBannerSteps = new WomenBannerSteps(webDriver);

    //Btn Women Options
    @Test (description = "Test de el contenido del banner del la opción Women",groups = {"womenTest"})
    public void womenBtnCLick() throws IOException {
        womenBannerSteps.openMyStore();
        womenBannerSteps.clickWOmenBtn();
        womenBannerSteps.getCurrentUrl();
        System.out.println("La URL actual es: " + womenBannerSteps.getCurrentUrl());
        Assert.assertEquals(womenBannerSteps.getCurrentUrl(),getPropertyValue("EXPECTED_WOMEN_MENU_URL"));

        Assert.assertTrue(womenBannerSteps.bannerIsDisplayed());

        Assert.assertEquals(womenBannerSteps.getCurrentUrl(),getPropertyValue("EXPECTED_WOMEN_MENU_URL"));
        Assert.assertEquals(womenBannerSteps.firstWomenBannerText(),getPropertyValue("EXPECTED_FIRST_WOMEN_BANNER_TEXT"));
        Assert.assertEquals(womenBannerSteps.secondWomenBannerText(),getPropertyValue("EXPECTED_SECOND_WOMEN_BANNER_TEXT"));
        Assert.assertEquals(womenBannerSteps.thirdWomenBannerText(),getPropertyValue("EXPECTED_NUMBER_OF_WOMEN_PRODUCTS_TEXT"));

    }

}
