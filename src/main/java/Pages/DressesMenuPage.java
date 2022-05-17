package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DressesMenuPage extends BasePage {

    WebDriver dressesWebDriver;

    @FindBy(how = How.XPATH, using = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='Dresses']")
    private WebElement dressesMenuXpath;

    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat_bg']")
    private WebElement dressesBannerXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[1]")
    private WebElement firstDressesBannerTextXpath;

    @FindBy(how = How.XPATH, using = "(//div[@class='content_scene_cat_bg']//p)[2]")
    private WebElement secondDressesBannerTextXpath;

    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']")
    private WebElement numberOfDressesProductsText;

    public DressesMenuPage(WebDriver webDriver) {
        this.dressesWebDriver = webDriver;
    }

    public WebElement getDressesMenuElement() {
        return dressesMenuXpath;
    }

    public WebElement getDressesBanner() {
        return dressesBannerXpath;
    }

    public WebElement getFirstDressesBannerTextElement() {
        return firstDressesBannerTextXpath;
    }

    public WebElement getSecondDressesBannerTextElement() {
        return secondDressesBannerTextXpath;
    }

    public WebElement getNumberOfDressesProductsTextElement() {
        return numberOfDressesProductsText;
    }
}
