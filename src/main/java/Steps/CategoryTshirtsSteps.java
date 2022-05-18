package Steps;

import Pages.CategoryTshirtsPage;
import Pages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CategoryTshirtsSteps extends BaseSteps{
    MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);
    //CategoryTshirtsPage _categoryTshirtsPage = new CategoryTshirtsPage(_webDriver);
    CategoryTshirtsPage _categoryTshirtsPage = PageFactory.initElements(_webDriver, CategoryTshirtsPage.class);

    public CategoryTshirtsSteps(WebDriver webDriver) {
        super(webDriver);
        System.out.println("Constructor en categoryTshirtsSteps.java");
    }

    public void clickTshirtsMenu() {
        WebElement womenTshirts = _myStoreHomePage.getTshirtsMenu();
        System.out.println("Clic en Menú T-shirts de Home");
        womenTshirts.click();
    }

    public Boolean verifyURLCategoryTshirts(){
        String tshirtsURLActual = _webDriver.getCurrentUrl();
        String tshirtsURLExpected = "http://automationpractice.com/index.php?id_category=5&controller=category";
        Boolean urlValidate = tshirtsURLActual.equals(tshirtsURLExpected);
        return urlValidate;
    }

    public Boolean verifyTshirtsBanner() {
        System.out.println("Metodo verifyTshirtsBanner en CategoryTshirtsSteps.java");
        WebElement tshirtsBannerWebElement = _categoryTshirtsPage.getBannerTshirtsWebElement();
        return tshirtsBannerWebElement.isDisplayed();//true or false
    }

    public String verifyTshirtsText() {
        System.out.println("Metodo verifyTshirtsText en CategoryTshirtsSteps.java");
        WebElement tshirtsTextWebElement = _categoryTshirtsPage.getTextTshirtsWebElement();
        String text = tshirtsTextWebElement.getText();
        return text;//Texto 1
    }

    public String verifyTshirtsText2() {
        System.out.println("Metodo verifyTshirtsText2 en CategoryTshirtsSteps.java");
        WebElement tshirtsText2WebElement = _categoryTshirtsPage.getText2TshirtsWebElement();
        String text = tshirtsText2WebElement.getText();
        return text;//Texto 2
    }

    public String verifyTshirtsResults() {
        System.out.println("Metodo verifyTshirtsResults en CategoryTshirtsSteps.java");
        WebElement tshirtsResultsWebElement = _categoryTshirtsPage.getResultsTshirtsWebElement();
        String text = tshirtsResultsWebElement.getText();
        return text;//Results/Products
    }

}