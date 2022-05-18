package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryWomenPage extends BasePage {
    WebDriver _webDriverWomen;


    @FindBy(how = How.CSS, using = "#center_column > div.content_scene_cat > div")
    private WebElement bannerWomen;

    @FindBy(how = How.CSS, using = "#center_column > div.content_scene_cat > div > div > div > p:nth-child(2)")
    private WebElement textWomen;

    @FindBy(how = How.CSS, using = "#center_column > div.content_scene_cat > div > div > div > p:nth-child(3)")
    private WebElement text2Women;

    @FindBy(how = How.CSS, using = "#center_column > h1 > span.heading-counter")
    private WebElement resultsWomen;


    public CategoryWomenPage(WebDriver _webDriverWomen) {
        this._webDriverWomen = _webDriverWomen;
        System.out.println("Constructor categoryWomenPage.java");
        this._webDriverWomen = _webDriverWomen;
    }


    public WebElement getBannerWomenWebElement() {
        System.out.println("Método getBannerWomenWebElement en CategoryWomenPage.java");
        return bannerWomen;
    }

    public WebElement getTextWomenWebElement() {
        System.out.println("Método getTextWomenWebElement en CategoryWomenPage.java");
        return textWomen;
    }

    public WebElement getText2WomenWebElement() {
        System.out.println("Método getText2WomenWebElement en CategoryWomenPage.java");
        return text2Women;
    }

    public WebElement getResultsWomenWebElement() {
        System.out.println("Método getResultsWomenWebElement en CategoryWomenPage.java");
        return resultsWomen;
    }
}
