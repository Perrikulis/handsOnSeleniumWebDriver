package Steps;

import Pages.MyStoreWomenPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStoreWomenSteps extends BaseSteps{

    MyStoreWomenPage womenPage = PageFactory.initElements(_webDriver, MyStoreWomenPage.class);

    public MyStoreWomenSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void openWomenCategory(){
        womenPage.getWomenCategoryElement().click();
    }

    public boolean verifyBannerDisplayed(){
        WebElement banner = womenPage.getBannerWomenCategory();
        return banner.isDisplayed();
    }

    public String getParagraphBanner(int index){
        List<WebElement> parrafos = womenPage.getParagraphBannerWomenCategory();
        return parrafos.get(index).getText();
    }

    public String getCounterParagraph(){
        WebElement parragraphCounter = womenPage.getParagraphHeadingCounter();
        return parragraphCounter.getText();
    }

    public String getURLActual(){
        return _webDriver.getCurrentUrl();
    }
}