package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class MyStoreDressesPage extends BasePage {
    WebDriver webDriverMyStore;

    public MyStoreDressesPage(WebDriver webDriverMyStore) {
        this.webDriverMyStore = webDriverMyStore;
    }

    @FindBy(how = How.XPATH,  using = "//span[contains(@class,\"category-name\")]")
    private WebElement dressesBannerTitleXpath;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,\"rte\")]//descendant::p")
    private List<WebElement> dressesParagraphs;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,\"heading-counter\")]")
    private WebElement listResultText;

    public WebElement getDressesBannerTitle(){
        return dressesBannerTitleXpath;
    }

    public List<WebElement> getDressesParagraphs(){
        return dressesParagraphs;
    }

    public WebElement getListResultText(){
        return listResultText;
    }
}
