package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStoreWomenPage extends BasePage {
    WebDriver webDriverMyStore;

    // Selectores
    private final String bannerClassSelector="content_scene_cat";
    private final String paragraphBannerCssSelector = "div.cat_desc>div.rte>p";
    private final String paragraphHeadingCounter = ".page-heading.product-listing .heading-counter";

    public MyStoreWomenPage(WebDriver webDriverMyStore) {
        this.webDriverMyStore = webDriverMyStore;
    }

    public WebElement getBannerWomenCategory(){
        return webDriverMyStore.findElement(By.className(bannerClassSelector));
    }

    public List<WebElement> getParagraphBannerWomenCategory(){
        return webDriverMyStore.findElements(By.cssSelector(paragraphBannerCssSelector));
    }

    public WebElement getParagraphHeadingCounter(){
        return webDriverMyStore.findElement(By.cssSelector(paragraphHeadingCounter));
    }
}
