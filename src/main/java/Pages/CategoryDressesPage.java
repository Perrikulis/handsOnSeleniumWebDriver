package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryDressesPage extends BasePage {
    WebDriver _webDriverDresses;


    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat']")
    private WebElement bannerDresses;

    @FindBy(how = How.XPATH, using = "//div[@class='cat_desc']/div[@class='rte']//p[1]")
    private WebElement textDresses;

    @FindBy(how = How.XPATH, using = "//div[@class='cat_desc']/div[@class='rte']//p[2]")
    private WebElement text2Dresses;

    @FindBy(how = How.XPATH, using = "//h1/span[2]")
    private WebElement resultsDresses;

    public CategoryDressesPage (WebDriver _webDriverDresses){
        this._webDriverDresses = _webDriverDresses;
        System.out.println("Constructor categoryDressesPage.java");
        this._webDriverDresses = _webDriverDresses;
    }
    public WebElement getBannerDressesWebElement(){
        System.out.println("Método getBannerDress");
        return bannerDresses;
    }

    public WebElement getTextDressesWebElement (){
        System.out.println("Método getTextDresses");
        return textDresses;
    }
    public WebElement getText2DressesWebElement (){
        System.out.println("Método getText2Dresses");
        return text2Dresses;
    }
    public WebElement getResultsDressesWebElement(){
        System.out.println("Método getResultsDresses");
        return resultsDresses;
    }
}
