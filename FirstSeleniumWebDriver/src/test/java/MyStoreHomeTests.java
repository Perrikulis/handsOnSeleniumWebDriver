import Pages.MyStoreHomePage;
import Pages.SearchResultsPage;
import Steps.MyStoreHomeSteps;
import Steps.SearchResultsSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreHomeTests extends BaseTest {
    private WebDriver _childWebDriver = webDriver;
    SearchResultsSteps searchResultsSteps = new SearchResultsSteps(_childWebDriver);
    MyStoreHomeSteps _myStoreHomeSteps = new MyStoreHomeSteps(_childWebDriver);

    //Localizadores o Selectors
    final String logoCSSLocatorFalse = "div.header_logo";
    final String logoCSSLocator = "div#header_logo";
    final String cartCSSLocator = "div.shopping_cart > a";
    final String searchTextBoxIdLocator = "search_query_top";
    final String btnSearchCSSLocator = "form#searchbox > button";
    final String searchTextBoxCSSLocator = "div > form#searchbox";

    final String menuListClassSelector = "ul.sf-menu>li>a";
    final String bannerWomenClassSelector = "div.content_scene_cat_bg";
    final String searchRestBannerClassSelector = "div.product-container";




    @Test
    public void testSearchFirstElement() {
        searchResultsSteps.openMyStore();
        WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
        System.out.println(logo.isDisplayed());
    }

    @Test
    public void testManejoDeException() {
        searchResultsSteps.openMyStore();
        try {
            //Ejemplo
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalse));
            System.out.println("Codigo try: " + logo.isDisplayed());
        } catch (NoSuchElementException logoNoLocalizado) {
            System.out.println("Catch logoNoLocalizado: El localizador " + logoCSSLocatorFalse + " no funciona.");
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            System.out.println("El logo se esta mostrando: " + logo.isDisplayed());
        }
    }

    @Test
    public void testManejoDeException2() {
        searchResultsSteps.openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            Assert.assertTrue(logo.isDisplayed(), "Mensaje de error");
            System.out.println("El elemento fue localizado usando: " + logoCSSLocator);
        } catch (NoSuchElementException elementoNoLocalizado) {
            Assert.fail("El elemento no fue encontrado con el localizador: " + logoCSSLocatorFalse);
        }
    }

    @Test
    public void testManejoDeException2Fails() {
        searchResultsSteps.openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalse));
            Assert.assertTrue(logo.isDisplayed(), "Mensaje de error");
            System.out.println("El elemento fue localizado usando: " + logoCSSLocatorFalse);
        } catch (NoSuchElementException elementoNoLocalizado) {
            Assert.fail("El elemento no fue encontrado con el localizador: " + logoCSSLocatorFalse);
        }
    }

    //1. Abrir My Store
    //2. Click en Carrito
    //3. Verificar que la URL que se abre es: http://automationpractice.com/index.php?controller=order

    @Test
    public void testURLCart() {
        searchResultsSteps.openMyStore();
        WebElement cart = _childWebDriver.findElement(By.cssSelector(cartCSSLocator));
        cart.click();
        String cartURLActual = _childWebDriver.getCurrentUrl();
        String cartURLExpected = "http://automationpractice.com/index.php?controller=order";
        Assert.assertEquals(cartURLActual, cartURLExpected,
                "Error: URL actual and expected do not match.");
    }

    @Test
    public void testSearchTextBox() {
        //Tarea para el proximo Sabado 2 de abril 2022
        //Test para localizar la caja de busqueda de My Store testSearchBoxPresent()
        //Requerimiento al entrar a My Store la caja de busqueda (Search text box) debe estar visible
        //Leer la Guia Rapida de GitHub (Crear branch y subir al repo)
        //Mandar usuario a Jenny por correo o por Slack
        searchResultsSteps.openMyStore();
        WebElement searchTextBox = _childWebDriver.findElement(By.cssSelector(searchTextBoxCSSLocator));
        Assert.assertTrue(searchTextBox.isDisplayed(), "Search text box not displayed.");
    }

    @Test
    public void testSendTextToSearchTextBox() {

        //Variables que se van a usar en la prueba
        String textToSearch = "women";

        //Acciones o pasos de prueba
        searchResultsSteps.openMyStore();
        //Elementos que se usaran en toda la prueba
        WebElement searchTextBox = _childWebDriver.findElement(By.id(searchTextBoxIdLocator));
        WebElement buttonSearch = _childWebDriver.findElement(By.cssSelector(btnSearchCSSLocator));

        searchTextBox.sendKeys(textToSearch);
        buttonSearch.click();


        Boolean resultsDisplayed = searchResultsSteps.verifySearchResults();

        System.out.println("Results displayed: " + resultsDisplayed);

        //Verificar que se hayan abierto la pagina de resultados
        //Tarea 02 de Abril 2022 Agregar Assert
        Assert.assertTrue(resultsDisplayed, "Error: Yellow alert is not present.");
    }

    @Test
    public void testMenuOption() {
        String option = "Dresses";

        _myStoreHomeSteps.openMyStore();
        String menuItemTileAct = _myStoreHomeSteps.getMenuItemTitle(option);

        //Agregar assert
        Assert.assertEquals(menuItemTileAct, option);

    }

    @Test
    public void testWOmenCategory() {

        //Abrir la pagina
        _myStoreHomeSteps.openMyStore();
        WebElement womenBtn = _childWebDriver.findElement(By.cssSelector(menuListClassSelector));
        womenBtn.click();
        String categoryPageTitle = _childWebDriver.getTitle();
        String categoryPageurs = _childWebDriver.getCurrentUrl();
        //Validar el titulo y url
        Assert.assertEquals(categoryPageTitle, "Women - My Store");
        Assert.assertEquals(categoryPageurs, "http://automationpractice.com/index.php?id_category=3&controller=category");
        //Validar el banner
        WebElement bannerWomen = _childWebDriver.findElement(By.cssSelector(bannerWomenClassSelector));
        bannerWomen.isDisplayed();
        Assert.assertTrue(bannerWomen.isDisplayed(), "The Banner is not displayed.");
        //Validar el texto del banner
        String bannerTxt = bannerWomen.getText();
        System.out.println(bannerTxt);
        Assert.assertEquals(bannerTxt, "Women" + "\n" +
                "You will find here all woman fashion collections." + "\n" +
                "This category includes all the basics of your wardrobe and much more:" + "\n" +
                "shoes, accessories, printed t-shirts, feminine dresses, women's jeans!");

       //Validar el producto mostrado
        WebElement produt = _childWebDriver.findElement(By.cssSelector(searchRestBannerClassSelector));

        Assert.assertTrue(produt.isDisplayed(), "The product is NOT displayed");


    }
}