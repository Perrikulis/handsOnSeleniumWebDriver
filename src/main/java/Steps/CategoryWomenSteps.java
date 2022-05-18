package Steps;

import Pages.CategoryWomenPage;
import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.MyStoreHomePage;
import org.openqa.selenium.support.PageFactory;

public class CategoryWomenSteps extends BaseSteps {
    MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);

    CategoryWomenPage _categoryWomenPage = PageFactory.initElements(_webDriver, CategoryWomenPage.class);

    public CategoryWomenSteps(WebDriver _webDriver) {
        super(_webDriver);
        System.out.println("Constructor en categoryWomenSteps.java");
    }

    public void clickWomenMenu() {
        WebElement womenMenu = _myStoreHomePage.getWomenMenu();
        System.out.println("Clic en Menú Women de Home");
        womenMenu.click();
    }

    public Boolean verifyURLCategoryWomen(){
        String womenURLActual = _webDriver.getCurrentUrl();
        String womenURLExpected = "http://automationpractice.com/index.php?id_category=3&controller=category";
        Boolean urlValidate = womenURLActual.equals(womenURLExpected);
        return urlValidate;
    }


    public Boolean verifyWomenBanner() {
        System.out.println("Metodo verifyWomenBanner en CategoryWomenSteps.java");
        WebElement womenBannerWebElement = _categoryWomenPage.getBannerWomenWebElement();
        return womenBannerWebElement.isDisplayed();//true or false
    }

    public String verifyWomenText() {
        System.out.println("Metodo verifyWomenText en CategoryWomenSteps.java");
        WebElement womenTextWebElement = _categoryWomenPage.getTextWomenWebElement();
        String text = womenTextWebElement.getText();
        return text;//Texto 1
    }


    public String verifyWomenText2() {
        System.out.println("Metodo verifyWomenText2 en CategoryWomenSteps.java");
        WebElement womenText2WebElement = _categoryWomenPage.getText2WomenWebElement();
        String text = womenText2WebElement.getText();
        return text;//Texto 2
    }


    public String verifyWomenResults() {
        System.out.println("Metodo verifyWomenResults en CategoryWomenSteps.java");
        WebElement womenResultsWebElement = _categoryWomenPage.getResultsWomenWebElement();
        String text = womenResultsWebElement.getText();
        return text;//Results/Products
    }


}
