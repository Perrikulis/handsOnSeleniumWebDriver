package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class WomenBannerPage extends BasePage {

    WebDriver webDriverWomenBaner;

    public WomenBannerPage(WebDriver _webDriverWomenBaner) {
        this.webDriverWomenBaner = _webDriverWomenBaner;
    }

    //Boton Women
    @FindBy(how = How.XPATH, using = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women']")
    private WebElement womenBtnXpath;



    //Banner y texto (Option Women)
    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat_bg']")
    private WebElement womenBannerXpath;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[2]")
    private WebElement womenText1Xpath;
    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[3]")
    private WebElement womenText2Xpath;
    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement womenText3Xpath;

    public WebElement getWomenBtnXpath() {
        return womenBtnXpath;
    }
    public WebElement getWomenBannerXpath() {
        return womenBannerXpath;
    }
    public WebElement getWomenText1Xpath() {
        return womenText1Xpath;
    }
    public WebElement getWomenText2Xpath() {
        return womenText2Xpath;
    }
    public WebElement getWomenText3Xpath() {
        return womenText3Xpath;
    }







}
