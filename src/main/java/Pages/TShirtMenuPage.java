package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TShirtMenuPage extends BasePage {

    WebDriver tShirtWebDriver;

    @FindBy(how = How.XPATH, using = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='T-shirts']")
    private WebElement tShirtMenuXpath;

    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat_bg']")
    private WebElement tShirtBannerXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[1]")
    private WebElement firstTShirtBannerTextXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[2]")
    private WebElement secondTShirtBannerTextXpath;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement numberOfTShirtProductsText;

    public TShirtMenuPage(WebDriver webDriver) {
        this.tShirtWebDriver = webDriver;
    }

    public WebElement getTShirtMenuElement() {
        return tShirtMenuXpath;
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
