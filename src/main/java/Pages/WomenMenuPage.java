package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WomenMenuPage extends BasePage {

    WebDriver womenWebDriver;

    @FindBy(how = How.XPATH, using = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women']")
    private WebElement womenMenuXpath;

    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat_bg']")
    private WebElement womenBannerXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[2]")
    private WebElement firstWomenBannerTextXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[3]")
    private WebElement secondWomenBannerTextXpath;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement numberOfWomenProductsTextXpath;

    public WomenMenuPage(WebDriver webDriver) {
        this.womenWebDriver = webDriver;
    }

    public WebElement getWomenMenuElement() {
        return womenMenuXpath;
    }

    public WebElement getWomenBanner() {
        return womenBannerXpath;
    }

    public WebElement getFirstWomenBannerTextElement() {
        return firstWomenBannerTextXpath;
    }

    public WebElement getSecondWomenBannerTextElement() {
        return secondWomenBannerTextXpath;
    }

    public WebElement getNumberOfWomenProductsTextElement() {
        return numberOfWomenProductsTextXpath;
    }
}
