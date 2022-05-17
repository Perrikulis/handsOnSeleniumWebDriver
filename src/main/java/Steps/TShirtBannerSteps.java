package Steps;

import Pages.DressesBannerPage;
import Pages.TShirtsBannerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TShirtBannerSteps extends BaseSteps {

    TShirtsBannerPage tShirtsBannerPage = PageFactory.initElements(_webDriver, TShirtsBannerPage.class);

    public TShirtBannerSteps(WebDriver webDriver) {

        super(webDriver);
    }

    //Btn Dresses Options
    public void clickTshirtBtn() {
        tShirtsBannerPage.gettShirtsBtnXpath().click();
    }
    public String getCurrentTShirtMenuURL() {
        return _webDriver.getCurrentUrl();
    }

    public Boolean isTShirtBannerDisplayed() {
        return tShirtsBannerPage.getTShirtBanner().isDisplayed();
    }

    public String getFirstTShirtBannerText() {
        return tShirtsBannerPage.getFirstTShirtBannerTextElement().getText();
    }

    public String getSecondTShirtBannerText() {
        return tShirtsBannerPage.getSecondTShirtBannerTextElement().getText();
    }

    public String getNumberOfTShirtProductsText() {
        return tShirtsBannerPage.getNumberOfTShirtProductsTextElement().getText();
    }
}
