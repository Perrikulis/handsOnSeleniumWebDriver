package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryTshirtsPage extends BasePage{
    WebDriver _webDriverTshirts;

    /*final String bannerTshirtsxPathLocator = "//div[@class='content_scene_cat']";
    final String textTshirtsxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p";
    final String text2TshirtsxPathLocator = "//*[@id='center_column']/div[1]/div/div/div/p[2]";
    final String resultsTshirtsxPathLocator = "//h1/span[2]";*/

    @FindBy(how = How.XPATH, using = "//div[@class='content_scene_cat']")
    private WebElement bannerTshirts;

    @FindBy(how = How.XPATH, using = "//div[@class='cat_desc']/div[@class='rte']//p")
    private WebElement textTshirts;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/div[1]/div/div/div/p[2]")
    private WebElement text2Tshirts;

    @FindBy(how = How.XPATH, using = "//h1/span[2]")
    private WebElement resultsTshirts;

    public CategoryTshirtsPage(WebDriver _webDriverTshirts){
        this._webDriverTshirts = _webDriverTshirts;
        System.out.println("Constructor categoryTshirtsPage");
        this._webDriverTshirts = _webDriverTshirts;
    }

    public WebElement getBannerTshirtsWebElement(){
        System.out.println("Metodo getBannerTshirts");
        return bannerTshirts;
    }

    public WebElement getTextTshirtsWebElement (){
        System.out.println("Metodo getTextTshirts");
        return textTshirts;
    }

    public WebElement getText2TshirtsWebElement (){
        System.out.println("Metodo getText2Tshirts");
        return text2Tshirts;
    }

    public WebElement getResultsTshirtsWebElement(){
        System.out.println("Metodo getResultsTshirts");
        return resultsTshirts;
    }
}
