package Steps;

import Pages.WomenBannerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WomenBannerSteps extends BaseSteps {

    WomenBannerPage womenBannerPage = PageFactory.initElements(_webDriver, WomenBannerPage.class);

    public WomenBannerSteps(WebDriver webDriver) {

        super(webDriver);
    }

    //Btn Women Options
    public void clickWOmenBtn() {

        womenBannerPage.getWomenBtnXpath().click();
    }

    public String getCurrentUrl() {
        String actualURL = _webDriver.getCurrentUrl();
        return actualURL;
    }

    public String getElementBanner() {
        String actualURL = _webDriver.getCurrentUrl();
        return actualURL;
    }

    public boolean bannerIsDisplayed(){
        return  womenBannerPage.getWomenBannerXpath().isDisplayed();
    }
    public String firstWomenBannerText() {
        return womenBannerPage.getWomenText1Xpath().getText();
    }

    public String secondWomenBannerText() {

        return womenBannerPage.getWomenText2Xpath().getText();
    }

    public String thirdWomenBannerText() {

        return womenBannerPage.getWomenText3Xpath().getText();
    }


}
