package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryTshirtsPage {
    WebDriver _webDriverTshirts;
    final String bannerTshirtsxPathLocator = "//div[@class='content_scene_cat']";
    final String textTshirtsxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p";
    final String resultsTshirtsxPathLocator = "//h1/span[2]";

    public CategoryTshirtsPage (WebDriver _webDriverDresses){
        this._webDriverTshirts = _webDriverTshirts;
        System.out.println("Constructor categoryTshirtsPage");
        this._webDriverTshirts = _webDriverTshirts;
    }
    public WebElement getBannerTshirtsWebElement(){
        System.out.println("Metodo getBannerDress");
        WebElement bannerTshirts = _webDriverTshirts.findElement(By.xpath(bannerTshirtsxPathLocator));
        return bannerTshirts;
    }

    public WebElement getTextDressesWebElement (){
        System.out.println("Metodo getTextDresses");
        WebElement textTshirts = _webDriverTshirts.findElement(By.xpath(textTshirtsxPathLocator));
        return textTshirts;
    }

    public WebElement getResultsDressWebElement(){
        System.out.println("Metodo getResultsDress");
        WebElement resultsTshirts = _webDriverTshirts.findElement(By.xpath(resultsTshirtsxPathLocator));
        return resultsTshirts;
    }
}
