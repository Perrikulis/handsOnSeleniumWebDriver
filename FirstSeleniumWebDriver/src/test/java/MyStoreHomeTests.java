import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStoreHomeTests extends BaseTest {
    final String urlMyStore = "http://automationpractice.com/index.php";
    private WebDriver _childWevDriver = webDriver;
    final String searhLogo = "div#header_logo";
    final String searhLogoF = "div.header_logo";
    final String carritoBtn = "div.shopping_cart > a";
    final String urlExpected = "http://automationpractice.com/index.php?controller=order";
    final String urlMyStore1 = "http://automationpractice.com/index.php";
    final String searchBoxPage = "searchbox";
    final String searchBoxPage1 = "searchbox1";


    @Test
    public void testSearchFirstElement() {
        openMyStore();
        WebElement logo = _childWevDriver.findElement(By.cssSelector(searhLogo));
        System.out.println(logo.isDisplayed());
    }

    @Test
    public void testManejoDeException() {
        openMyStore();
        try {
            //Ejemplo
            WebElement logo = _childWevDriver.findElement(By.cssSelector(searhLogoF));
            System.out.println("Codigo try: " + logo.isDisplayed());
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("El localizador " + searhLogoF + "no funciona.");
            WebElement logo = _childWevDriver.findElement(By.cssSelector(searhLogo));
            System.out.println("El logo se esta mostrando: " + logo.isDisplayed());
        }
    }

    @Test
    public void testManejoDeException2() {
        openMyStore();
        try {
            WebElement logo = _childWevDriver.findElement(By.cssSelector(searhLogo));
            Assert.assertTrue(logo.isDisplayed(), "Mesaje de error ");
            System.out.println("Elemento no fue localizdo usando: " + searhLogo);
        } catch (NoSuchElementException elementoNoLocalizado) {
            Assert.fail("El elemento no fue encontrado con el localizador: " + searhLogoF);
        }
    }

    //1.Abrir my Strore
    //2.Click en carrito
    //3.Verificar que la URL que se abre es  http://automationpractice.com/index.php?controller=order


    @Test
    public void testURLCorrecta() {
        openMyStore();
        WebElement carrito = _childWevDriver.findElement(By.cssSelector(carritoBtn));
        carrito.click();
        String pageActual1 = _childWevDriver.getCurrentUrl();
        Assert.assertEquals(pageActual1, urlExpected);
        System.out.println("The URL corresta es " + urlExpected);
    }

    //Test para localizar la caja de busqueda de My Store testSearchBoxPresent()
    //Requerimiento al entrar a My Store la caja de busqueda (Search text box) debe estar visible
    //Leer la Guia Rapida de GitHub (Crear branch y subir al repo)
    //Mandar usuario a Jenny por correo o por Slack

    @Test
    public void testSearchBoxPresent() {

        openMyStore();
        WebElement serchBtn = _childWevDriver.findElement(By.id(searchBoxPage));


        //Valida la pagina
        String pageActual1 = _childWevDriver.getCurrentUrl();
        Assert.assertEquals(pageActual1, urlMyStore1);

        //Valido que el campo search este presente
        if (serchBtn.isDisplayed()) {
            System.out.println("El campo Search se muestra correctamente");
        } else {
            System.out.println("El campo Search no se muestra en la pantalla");
        }
    }

    private void openMyStore() {
        _childWevDriver.get(urlMyStore);
        System.out.println("El navegator ha abierto la URL: " + urlMyStore);
    }
}
