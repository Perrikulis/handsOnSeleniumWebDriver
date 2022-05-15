package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MyStoreTshirtsPage extends BasePage {
    WebDriver webDriverMyStore;

    public MyStoreTshirtsPage (WebDriver webDriverMyStore) {
        this.webDriverMyStore = webDriverMyStore;
    }

    @FindBy(how = How.CLASS_NAME, using = "content_scene_cat_bg")
    private WebElement banner;

    @FindBy(how = How.CSS, using = "div.cat_desc>div.rte>p")
    private List <WebElement> paragraphs_banner;

    @FindBy(how = How.CSS, using = ".page-heading.product-listing .heading-counter")
    private WebElement paragraphHeadingCounter;

    public WebElement getBannerTshirtsCategory(){
        return banner;
    }

    public List<WebElement> getParagraphBannerTshirtsCategory(){
        return paragraphs_banner;
    }

    public WebElement getParagraphHeadingCounter(){
        return paragraphHeadingCounter;
    }
}