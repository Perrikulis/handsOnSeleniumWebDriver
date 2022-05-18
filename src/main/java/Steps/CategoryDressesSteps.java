package Steps;

import Pages.CategoryDressesPage;
import Pages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CategoryDressesSteps extends BaseSteps{
    MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);

    CategoryDressesPage _categoryDressesPage = PageFactory.initElements(_webDriver, CategoryDressesPage.class);

    public CategoryDressesSteps(WebDriver _webDriver) {
        super(_webDriver);
        System.out.println("Constructor en categoryDressesSteps.java");
    }

    public void clickDressesMenu() {
        WebElement dressesMenu = _myStoreHomePage.getDressesMenu();
        System.out.println("Clic en Menú Dresses de Home");
        dressesMenu.click();
    }

    public Boolean verifyURLCategoryDresses(){
        String dressesURLActual = _webDriver.getCurrentUrl();
        String dressesURLExpected = "http://automationpractice.com/index.php?id_category=8&controller=category";
        Boolean urlValidate = dressesURLActual.equals(dressesURLExpected);
        return urlValidate;
    }

    public Boolean verifyDressesBanner() {
        System.out.println("Método verifyDressesBanner en CategoryDressesSteps.java");
        WebElement dressesBannerWebElement = _categoryDressesPage.getBannerDressesWebElement();
        return dressesBannerWebElement.isDisplayed();//true or false
    }

    public String verifyDressesText() {
        System.out.println("Método verifyDressesText en CategoryDressesSteps.java");
        WebElement dressesTextWebElement = _categoryDressesPage.getTextDressesWebElement();
        String text = dressesTextWebElement.getText();
        return text;//Texto 1
    }

    public String verifyDressesText2() {
        System.out.println("Método verifyDressesText2 en CategoryDressesSteps.java");
        WebElement dressesText2WebElement = _categoryDressesPage.getText2DressesWebElement();
        String text = dressesText2WebElement.getText();
        return text;//Texto 2
    }

    public String verifyDressesResults() {
        System.out.println("Método verifyWomenResults en CategoryWomenSteps.java");
        WebElement dressesResultsWebElement = _categoryDressesPage.getResultsDressesWebElement();
        String text = dressesResultsWebElement.getText();
        return text;//Results/Products
    }
}


