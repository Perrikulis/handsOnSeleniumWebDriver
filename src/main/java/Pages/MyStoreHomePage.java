package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStoreHomePage extends BasePage {
    WebDriver webDriverMyStoreHome;
    private final String menuListClassSelector = "ul.sf-menu>li>a";
    private final String WomenMenuCSSelector = "#block_top_menu > ul > li:nth-child(1) > a";

    private final String DressesMenuxPathSelector = "(//a[contains(text(),'Dresses')])[5]";
    private final String TshirtsMenuxPathSelector = "(//a[contains(text(),'T-shirts')])[2]";


    public MyStoreHomePage(WebDriver _webDriverMyStoreHome) {
        this.webDriverMyStoreHome = _webDriverMyStoreHome;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public List<WebElement> getMenuList() {
        List<WebElement> listaMenu = webDriverMyStoreHome.findElements(By.cssSelector(menuListClassSelector));
        return listaMenu;
    }
    //Este metodo se manda llamar desdee CategoryWomenSteps
    public WebElement getWomenMenu()
    {
        WebElement womenMenu = webDriverMyStoreHome.findElement(By.cssSelector(WomenMenuCSSelector));
        return womenMenu;
    }

    public WebElement getDressesMenu(){
        WebElement dressesMenu = webDriverMyStoreHome.findElement(By.xpath(DressesMenuxPathSelector));
        return dressesMenu;
    }

    public WebElement getTshirtsMenu(){
        WebElement tshirtsMenu = webDriverMyStoreHome.findElement(By.xpath(TshirtsMenuxPathSelector));
        return tshirtsMenu;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public WebElement getMenuItem(String menuItemName) {
        WebElement itemToReturn = getMenuList().get(0);
        for(WebElement item : getMenuList()) {
            String title = item.getAttribute("title");
            System.out.println("Current item is: " + title);
            if (title.equals(menuItemName)) {
                itemToReturn =  item;
                System.out.println("option found: " + title);
                break;
            }
        }
        return itemToReturn;
    }


}
