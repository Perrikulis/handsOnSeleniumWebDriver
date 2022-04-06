import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreHomeTests extends BaseTest{

    private WebDriver _childWebDriver = webDriver;
    final String urlMyStore = "http://automationpractice.com/index.php";

    //Localizadores o selectores
    final String logoCSSLocator = "div#header_logo";
    final String logoCSSLocatorFalso = "div.header_logo";
    final String carritoCSSLocator = "div.shopping_cart > a";
    final String searchTextBoxCSSLocator = "div > form#searchbox";
    final String searchTextBoxIdLocator = "search_query_top";
    final String buttonSearchCSSLocator = "form#searchbox > button";

    @Test
    public void testSearchFirstElement(){
        openMyStore();
        WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
        System.out.println(logo.isDisplayed());
    }

    @Test
    public void testExceptionManagement(){
        openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalso));
            System.out.println("Código try: " + logo.isDisplayed());
        }
        //Se utiliza NoSuchElementException de selenium
        catch (NoSuchElementException logoNoLocalizado){
            System.out.println("Catch logo no localizado: El localizador " + logoCSSLocatorFalso + " no funciona.");
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            System.out.println("El logo se está mostrando: " + logo.isDisplayed());
        }
    }

    @Test
    public void testExceptionManagement2(){
        openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            Assert.assertTrue(logo.isDisplayed(), "Mensaje de error");
            System.out.println("El elemento fue localizado usando: " + logoCSSLocator);
        }catch (NoSuchElementException elementoNoLocalizado){
            Assert.fail("El elemento no fue encontrado con el localizador: " + logoCSSLocatorFalso);
        }
    }

    @Test
    public void testExceptionManagement2Fails(){
        openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalso));
            //logo.click();
            Assert.assertTrue(logo.isDisplayed(), "Mensaje de error");
            System.out.println("El elemento fue localizado usando: " + logoCSSLocatorFalso);
        }catch (NoSuchElementException elementoNoLocalizado){
            Assert.fail("El elemento no fue encontrado con el localizador: " + logoCSSLocatorFalso);
        }
    }

    //1. Abrir MyStore
    //2. Click en Carrito
    //3. Verificar que la URL que se abre es http://automationpractice.com/index.php?controller=order

    @Test
    public void testVerificaURLCarrito(){
        openMyStore();
        try{
            WebElement carrito = _childWebDriver.findElement(By.cssSelector(carritoCSSLocator));
            Assert.assertTrue(carrito.isDisplayed(), "No se encontró el carrito");
            carrito.click();
        }catch (NoSuchElementException elementoNoLocalizado){
            Assert.fail("El elemento no fue encontrado con el localizador: " + carritoCSSLocator);
        }
        String carritoURLActual = _childWebDriver.getCurrentUrl();
        String carritoURLExpected = "http://automationpractice.com/index.php?controller=order";
        Assert.assertTrue(carritoURLExpected.equals(carritoURLActual),
                "La URL actual: " + carritoURLActual + " es diferente a la esperada: " + carritoURLExpected);
        System.out.println("La URL actual: " + carritoURLActual + " es igual a la esperada: " + carritoURLExpected);
    }

    //Tarea para el próximo sábado 2 de abril 2022
    //Test para localizar la caja de búsqueda de MyStore testSearchBoxPresent()
    //Requerimiento: al entrar a MyStore la caja de búsqueda (search text box) debe estar visible
    //Leer la guía rápida de GitHub (Crear branch y subir al repo)
    //Mandar usuario a Jenni por correo o por slack

    //Tarea
    @Test
    public void testSearchBoxPresent(){
        //Apertura de MyStore
        openMyStore();
        //Búsqueda del objeto por selector
        try{
            WebElement searchTextBox = _childWebDriver.findElement(By.cssSelector(searchTextBoxCSSLocator));
            Assert.assertTrue(searchTextBox.isDisplayed(), "No se encontró la caja de búsqueda");
            System.out.println("La caja de texto con localizador: " + searchTextBoxCSSLocator + " fue encontrada");
        }catch (NoSuchElementException elementoNoLocalizado){
            Assert.fail("El elemento no fue encontrado con el localizador: " + searchTextBoxCSSLocator);
        }
    }

    @Test
    public void testSendTextToSearchTextBox() {
        //Variables que se van a usar en la prueba
        String textToSearch = "women";

        //Acciones o pasos de prueba
        openMyStore();

        //Elementos que se usarán en la prueba
        WebElement searchTextBox = _childWebDriver.findElement(By.id(searchTextBoxIdLocator));
        WebElement buttonSearch = _childWebDriver.findElement(By.cssSelector(buttonSearchCSSLocator));

        searchTextBox.sendKeys(textToSearch);
        buttonSearch.click();

        //Verificar que se hayan abierto la página de resultados
        SearchResultsPage resultsPage = new SearchResultsPage(_childWebDriver);
        Boolean resultsDisplayed = resultsPage.verifySearchResults();

        System.out.println("Results displayed: " + resultsDisplayed);
        //Tarea 02 de abril de 2022
        //Agregar Assert
        Assert.assertTrue(resultsDisplayed, "No se mostró la pagina de resultados");

    }

    private void openMyStore(){
        _childWebDriver.get(urlMyStore);
        System.out.println("El navegador ha abierto la URL " + urlMyStore);
    }
}
