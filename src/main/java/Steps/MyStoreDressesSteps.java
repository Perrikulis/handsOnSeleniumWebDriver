package Steps;

import Pages.MyStoreDressesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyStoreDressesSteps extends BaseSteps{

    MyStoreDressesPage myStoreDressesPage = PageFactory.initElements(_webDriver, MyStoreDressesPage.class);

    public MyStoreDressesSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getActualUrl(){
        return _webDriver.getCurrentUrl();
    }

    public Boolean titleBannerIsDisplayed(){
        return myStoreDressesPage.getDressesBannerTitle().isDisplayed();
    }

    public String getTitleFromBanner(){
        return myStoreDressesPage.getDressesBannerTitle().getText();
    }

    public String getTextParagraphLine(int numberLine){
        return myStoreDressesPage.getDressesParagraphs().get(numberLine).getText();
    }

    public String getTextListResult(){
        return myStoreDressesPage.getListResultText().getText();
    }

}
