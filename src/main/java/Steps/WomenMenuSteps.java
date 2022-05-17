package Steps;

import Pages.WomenMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WomenMenuSteps extends BaseSteps {

    WomenMenuPage womenMenuPage = PageFactory.initElements(_webDriver, WomenMenuPage.class);

    public WomenMenuSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickWomenMenu() {
        womenMenuPage.getWomenMenuElement().click();
    }

    public String getCurrentWomenMenuURL() {
        return _webDriver.getCurrentUrl();
    }

    public Boolean isWomenBannerDisplayed() {
        return womenMenuPage.getWomenBanner().isDisplayed();
    }

    public String getFirstWomenBannerText() {
        return womenMenuPage.getFirstWomenBannerTextElement().getText();
    }

    public String getSecondWomenBannerText() {
        return womenMenuPage.getSecondWomenBannerTextElement().getText();
    }

    public String getNumberOfWomenProductsText() {
        return womenMenuPage.getNumberOfWomenProductsTextElement().getText();
    }
}
