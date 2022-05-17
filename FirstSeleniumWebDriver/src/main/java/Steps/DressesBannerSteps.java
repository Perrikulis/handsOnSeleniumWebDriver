package Steps;

import Pages.DressesBannerPage;
import Pages.WomenBannerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DressesBannerSteps extends BaseSteps {

    DressesBannerPage dressesBannerPage = PageFactory.initElements(_webDriver, DressesBannerPage.class);

    public DressesBannerSteps(WebDriver webDriver) {

        super(webDriver);
    }


    //Btn Dresses Options
    public void clickDressesBtn() {

        dressesBannerPage.getDressesBtnXpath().click();
    }
    public String getCurrentDressesMenuURL() {
        return _webDriver.getCurrentUrl();
    }

    public Boolean isDressesBannerDisplayed() {
        return dressesBannerPage.getDressesBanner().isDisplayed();
    }

    public String getFirstDressesBannerText() {
        return dressesBannerPage.getFirstDressesBannerTextElement().getText();
    }

    public String getSecondDressesBannerText() {
        return dressesBannerPage.getSecondDressesBannerTextElement().getText();
    }

    public String getNumberOfDressesProductsText() {
        return dressesBannerPage.getNumberOfDressesProductsTextElement().getText();
    }
}
