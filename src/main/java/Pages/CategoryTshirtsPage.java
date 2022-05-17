package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryTshirtsPage extends BasePage{
    WebDriver _webDriverTshirts;
    final String bannerTshirtsxPathLocator = "//div[@class='content_scene_cat']";
    final String textTshirtsxPathLocator = "//div[@class='cat_desc']/div[@class='rte']//p";
    final String text2TshirtsxPathLocator = "//*[@id='center_column']/div[1]/div/div/div/p[2]";
    final String resultsTshirtsxPathLocator = "//h1/span[2]";

    public CategoryTshirtsPage(WebDriver _webDriverTshirts){
        this._webDriverTshirts = _webDriverTshirts;
        System.out.println("Constructor categoryTshirtsPage");
        this._webDriverTshirts = _webDriverTshirts;
    }

    public WebElement getBannerTshirtsWebElement(){
        System.out.println("Metodo getBannerTshirts");
        WebElement bannerTshirts = _webDriverTshirts.findElement(By.xpath(bannerTshirtsxPathLocator));
        return bannerTshirts;
    }

    public WebElement getTextTshirtsWebElement (){
        System.out.println("Metodo getTextTshirts");
        WebElement textTshirts = _webDriverTshirts.findElement(By.xpath(textTshirtsxPathLocator));
        return textTshirts;
    }

    public WebElement getText2TshirtsWebElement (){
        System.out.println("Metodo getText2Tshirts");
        WebElement textTshirts = _webDriverTshirts.findElement(By.xpath(text2TshirtsxPathLocator));
        return textTshirts;
    }

    public WebElement getResultsTshirtsWebElement(){
        System.out.println("Metodo getResultsTshirts");
        WebElement resultsTshirts = _webDriverTshirts.findElement(By.xpath(resultsTshirtsxPathLocator));
        return resultsTshirts;
    }
}
