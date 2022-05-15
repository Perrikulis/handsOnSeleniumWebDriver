package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MyStoreWomenPage extends BasePage {
    WebDriver webDriverMyStore;

    public MyStoreWomenPage(WebDriver webDriverMyStore) {
        this.webDriverMyStore = webDriverMyStore;
    }

    @FindBy(how = How.CLASS_NAME, using = "content_scene_cat")
    private WebElement banner;

    @FindBy(how = How.CSS, using = "div.cat_desc>div.rte>p")
    private List<WebElement> paragraphs_banner;

    @FindBy(how = How.CSS, using = ".page-heading.product-listing .heading-counter")
    private WebElement paragraphHeadingCounter;

    @FindBy(how = How.CSS, using = "#block_top_menu ul li a[title='Women']")
    private WebElement womenCategoryElement;

    public WebElement getBannerWomenCategory(){
        return banner;
    }

    public List<WebElement> getParagraphBannerWomenCategory(){
        return paragraphs_banner;
    }

    public WebElement getParagraphHeadingCounter(){
        return paragraphHeadingCounter;
    }

    public WebElement getWomenCategoryElement(){
        return womenCategoryElement;
    }
}