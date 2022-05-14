package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryDressesPage extends BasePage {
    WebDriver _webDriverDresses;
    final String bannerDressesxPathLocator = "//div[@class='content_scene_cat']";
    //final String textDressesxPathLocator = "//div[@id='center_column']/div/div/div/div/p[1]";
    final String textDressesxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p[1]";
    final String text2DressesxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p[2]";
    final String resultsDressesxPathLocator = "//h1/span[2]";

    public CategoryDressesPage (WebDriver _webDriverDresses){
        this._webDriverDresses = _webDriverDresses;
        System.out.println("Constructor categoryDressPage");
        this._webDriverDresses = _webDriverDresses;
    }
    public WebElement getBannerDressWebElement(){
        System.out.println("Metodo getBannerDress");
        WebElement bannerDress = _webDriverDresses.findElement(By.xpath(bannerDressesxPathLocator));
        return bannerDress;
    }

    public WebElement getTextDressesWebElement (){
        System.out.println("Metodo getTextDresses");
        WebElement textDress = _webDriverDresses.findElement(By.xpath(textDressesxPathLocator));
        return textDress;
    }
    public WebElement getText2DressesWebElement (){
        System.out.println("Metodo getText2Dresses");
        WebElement text2Dress = _webDriverDresses.findElement(By.xpath(text2DressesxPathLocator));
        return text2Dress;
    }
    public WebElement getResultsDressWebElement(){
        System.out.println("Metodo getResultsDress");
        WebElement resultsDresses = _webDriverDresses.findElement(By.xpath(resultsDressesxPathLocator));
        return resultsDresses;
    }
}
