package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryWomenPage extends BasePage {
    WebDriver _webDriverWomen;
    final String bannerWomenCSSLocator = "#center_column > div.content_scene_cat > div";
    final String textWomenCSSLocator = "#center_column > div.content_scene_cat > div > div > div > p:nth-child(2)";
    final String text2WomenCSSLocator = "#center_column > div.content_scene_cat > div > div > div > p:nth-child(3)";
    final String resultsWomenCSSLocator = "#center_column > h1 > span.heading-counter";

    public CategoryWomenPage(WebDriver _webDriverWomen) {
        this._webDriverWomen = _webDriverWomen;
        System.out.println("Constructor categoryWomenPage.java");
        this._webDriverWomen = _webDriverWomen;
    }

   // public getURLWomenCategory(){
   //     WebElement categoryWomen = _webDriverWomen.findElement()
   // }

    public WebElement getBannerWomenWebElement() {
        System.out.println("Metodo getBannerWomenWebElement en CategoryWomenPage.java");
        WebElement bannerWomen = _webDriverWomen.findElement(By.cssSelector(bannerWomenCSSLocator));
        return bannerWomen;
    }

    public WebElement getTextWomenWebElement() {
        System.out.println("Metodo getTextWomenWebElement en CategoryWomenPage.java");
        WebElement textWomen = _webDriverWomen.findElement(By.cssSelector(textWomenCSSLocator));
        return textWomen;
    }

    public WebElement getText2WomenWebElement() {
        System.out.println("Metodo getText2WomenWebElement en CategoryWomenPage.java");
        WebElement text2Women = _webDriverWomen.findElement(By.cssSelector(text2WomenCSSLocator));
        return text2Women;
    }

    public WebElement getResultsWomenWebElement() {
        System.out.println("Metodo getResultsWomenWebElement en CategoryWomenPage.java");
        WebElement resultsWomen = _webDriverWomen.findElement(By.cssSelector(resultsWomenCSSLocator));
        return resultsWomen;
    }
}
