import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreHomeTests extends BaseTest {
    final String urlMyStore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = webDriver;

    //Localizadores o Selectors
    final String logoCSSLocatorFalse = "div.header_logo";
    final String logoCSSLocator = "div#header_logo";
    final String cartCSSLocator = "div.shopping_cart > a";
    final String searchTextBoxIdLocator = "search_query_top";
    final String btnSearchCSSLocator = "form#searchbox > button";

    @Test
    public void testSearchFirstElement() {
        openMyStore();
        WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
        System.out.println(logo.isDisplayed());
    }

    @Test
    public void testManejoDeException() {
        openMyStore();
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
        openMyStore();
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
        openMyStore();
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
        openMyStore();
        WebElement cart = _childWebDriver.findElement(By.cssSelector(cartCSSLocator));
        cart.click();
        String cartURLActual = _childWebDriver.getCurrentUrl();
        String cartURLExpected = "http://automationpractice.com/index.php?controller=order";
        Assert.assertEquals(cartURLActual, cartURLExpected,
                "Error: URL actual and expected do not match.");
    }

    //Tarea para el proximo Sabado 2 de abril 2022
    //Test para localizar la caja de busqueda de My Store testSearchBoxPresent()
    //Requerimiento al entrar a My Store la caja de busqueda (Search text box) debe estar visible
    //Leer la Guia Rapida de GitHub (Crear branch y subir al repo)
    //Mandar usuario a Jenny por correo o por Slack

    @Test
    public void testSendTextToSearchTextBox() {
        //Variables que se van a usar en la prueba
        String textToSearch = "women";

        //Acciones o pasos de prueba
        openMyStore();
        //Elementos que se usaran en toda la prueba
        WebElement searchTextBox = _childWebDriver.findElement(By.id(searchTextBoxIdLocator));
        WebElement buttonSearch = _childWebDriver.findElement(By.cssSelector(btnSearchCSSLocator));

        searchTextBox.sendKeys(textToSearch);
        buttonSearch.click();

        SearchResultsPage resultsPage = new SearchResultsPage(_childWebDriver);
        Boolean resultsDisplayed = resultsPage.verifySearchResults();

        System.out.println("Results displayed: " + resultsDisplayed);

        //Verificar que se hayan abierto la pagina de resultados
        //Tarea 02 de Abril 2022 Agregar Assert
    }

    private void openMyStore() {
        _childWebDriver.get(urlMyStore);
        System.out.println("El navegador ha abierto la URL: " + urlMyStore);
    }
}
