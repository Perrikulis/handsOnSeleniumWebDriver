package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TShirtsBannerPage {

    WebDriver webDriverTShirtsBanner;

    public TShirtsBannerPage(WebDriver _webDriverWomenBaner) {
        this.webDriverTShirtsBanner = _webDriverWomenBaner;
    }


    //Boton T-Shirts
    @FindBy(how = How.XPATH, using = "(//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='T-shirts'])[2]")
    private WebElement tShirtsBtnXpath;

    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat_bg']")
    private WebElement tShirtBannerXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[1]")
    private WebElement firstTShirtBannerTextXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[2]")
    private WebElement secondTShirtBannerTextXpath;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement numberOfTShirtProductsText;





    //Banner y texto (Option Dresses)
    public WebElement gettShirtsBtnXpath() {
        return tShirtsBtnXpath;
    }

    public WebElement getTShirtBanner() {
        return tShirtBannerXpath;
    }

    public WebElement getFirstTShirtBannerTextElement() {
        return firstTShirtBannerTextXpath;
    }

    public WebElement getSecondTShirtBannerTextElement() {
        return secondTShirtBannerTextXpath;
    }

    public WebElement getNumberOfTShirtProductsTextElement() {
        return numberOfTShirtProductsText;
    }
}
