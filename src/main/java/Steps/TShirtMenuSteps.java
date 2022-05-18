package Steps;

import Pages.TShirtMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TShirtMenuSteps extends BaseSteps {

    TShirtMenuPage tShirtMenuPage = PageFactory.initElements(_webDriver, TShirtMenuPage.class);

    public TShirtMenuSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickTShirtMenu() {
        tShirtMenuPage.getTShirtMenuElement().click();
    }

    public String getCurrentTShirtMenuURL() {
        return _webDriver.getCurrentUrl();
    }

    public Boolean isTShirtBannerDisplayed() {
        return tShirtMenuPage.getTShirtBanner().isDisplayed();
    }

    public String getFirstTShirtBannerText() {
        return tShirtMenuPage.getFirstTShirtBannerTextElement().getText();
    }

    public String getSecondTShirtBannerText() {
        return tShirtMenuPage.getSecondTShirtBannerTextElement().getText();
    }

    public String getNumberOfTShirtProductsText() {
        return tShirtMenuPage.getNumberOfTShirtProductsTextElement().getText();
    }
}
