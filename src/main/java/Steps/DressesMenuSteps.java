package Steps;

import Pages.DressesMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DressesMenuSteps extends BaseSteps {

    DressesMenuPage dressesMenuPage = PageFactory.initElements(_webDriver, DressesMenuPage.class);

    public DressesMenuSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickDressesMenu() {
        dressesMenuPage.getDressesMenuElement().click();
    }

    public String getCurrentDressesMenuURL() {
        return _webDriver.getCurrentUrl();
    }

    public Boolean isDressesBannerDisplayed() {
        return dressesMenuPage.getDressesBanner().isDisplayed();
    }

    public String getFirstDressesBannerText() {
        return dressesMenuPage.getFirstDressesBannerTextElement().getText();
    }

    public String getSecondDressesBannerText() {
        return dressesMenuPage.getSecondDressesBannerTextElement().getText();
    }

    public String getNumberOfDressesProductsText() {
        return dressesMenuPage.getNumberOfDressesProductsTextElement().getText();
    }
}
