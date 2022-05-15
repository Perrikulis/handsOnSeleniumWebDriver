package Steps;

import Pages.MyStoreTshirtsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStoreTshirtsSteps  extends BaseSteps{

    public MyStoreTshirtsSteps (WebDriver webDriver) {
        super (webDriver);
    }
    MyStoreTshirtsPage tshirtsPage= PageFactory.initElements (_webDriver,MyStoreTshirtsPage.class);

    private final String tshirtsCategorySelector = "(//a[contains(text(),'T-shirts')])[2]";


    public void openTshirtsCategory (){
        WebElement womenCatBtn = _webDriver.findElement(By.xpath(tshirtsCategorySelector));
        womenCatBtn.click();
    }

    public boolean verifyBannerDisplayed(){
        WebElement banner = tshirtsPage.getBannerTshirtsCategory();
        return banner.isDisplayed();
    }

    public String getParagraphBanner(int index){
        List <WebElement> parrafos = tshirtsPage.getParagraphBannerTshirtsCategory();
        return parrafos.get(index).getText();
    }

    public String getCounterParagraph(){
        WebElement parragraphCounter = tshirtsPage.getParagraphHeadingCounter();
        return parragraphCounter.getText();
    }

    public String getURLActual(){
        return _webDriver.getCurrentUrl();
    }
}