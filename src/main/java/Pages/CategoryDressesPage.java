package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryDressesPage extends BasePage {
    WebDriver _webDriverDresses;
    final String bannerDressesxPathLocator = "//div[@class='content_scene_cat']";
    final String textDressesxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p[1]";
    final String text2DressesxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p[2]";
    final String resultsDressesxPathLocator = "//h1/span[2]";

    public CategoryDressesPage (WebDriver _webDriverDresses){
        this._webDriverDresses = _webDriverDresses;
        System.out.println("Constructor categoryDressesPage.java");
        this._webDriverDresses = _webDriverDresses;
    }
    public WebElement getBannerDressesWebElement(){
        System.out.println("Método getBannerDress");
        WebElement bannerDresses = _webDriverDresses.findElement(By.xpath(bannerDressesxPathLocator));
        return bannerDresses;
    }

    public WebElement getTextDressesWebElement (){
        System.out.println("Método getTextDresses");
        WebElement textDresses = _webDriverDresses.findElement(By.xpath(textDressesxPathLocator));
        return textDresses;
    }
    public WebElement getText2DressesWebElement (){
        System.out.println("Método getText2Dresses");
        WebElement text2Dresses = _webDriverDresses.findElement(By.xpath(text2DressesxPathLocator));
        return text2Dresses;
    }
    public WebElement getResultsDressesWebElement(){
        System.out.println("Método getResultsDresses");
        WebElement resultsDresses = _webDriverDresses.findElement(By.xpath(resultsDressesxPathLocator));
        return resultsDresses;
    }
}
