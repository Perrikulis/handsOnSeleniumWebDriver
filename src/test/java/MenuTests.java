import Steps.CategoryDressesSteps;
import Steps.CategoryTshirtsSteps;
import Steps.CategoryWomenSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest{
    CategoryWomenSteps _categoryWomenSteps = new CategoryWomenSteps(webDriver);
    CategoryTshirtsSteps _categoryTshirtsSteps = new CategoryTshirtsSteps(webDriver);
    CategoryDressesSteps _categoryDressesSteps = new CategoryDressesSteps(webDriver);

    @Test(description = "Tests para probar la categoria WOMEN del proyecto final")
    public void testSR1010(){
        //Step 1: Abrir My Store
        _categoryWomenSteps.openMyStore();
        //Step 2: Click in Women Menu
        _categoryWomenSteps.clickWomenMenu();
        //Step 3: Validate Women category URL
        Assert.assertTrue(_categoryWomenSteps.verifyURLCategoryWomen());
        //Step 4: Validate Women Banner
        Assert.assertTrue(_categoryWomenSteps.verifyWomenBanner());
        //Step 5: Validate Women Text
        Assert.assertEquals(_categoryWomenSteps.verifyWomenText(),"This category includes all the basics of your wardrobe and much more:");
        //Step 6: Validate Women Text 2
        Assert.assertEquals(_categoryWomenSteps.verifyWomenText2(),"shoes, accessories, printed t-shirts, feminine dresses, women's jeans!");
        //Step 7: Validate Women 7 products
        Assert.assertEquals(_categoryWomenSteps.verifyWomenResults(),"There are 7 products.");
    }
    @Test(description = "Test del Requerimiento SR1011, Menú Dresses")
    public void testSR1011() {
        //Step 1: Abrir My Store
        _categoryDressesSteps.openMyStore();
        //Step 2: Click in Dresses Menu
        _categoryDressesSteps.clickDressesMenu();
        //Step 3: Validate Dresses category URL
        Assert.assertTrue(_categoryDressesSteps.verifyURLCategoryDresses());
        //Step 4: Validate Dresses Banner
        Assert.assertTrue(_categoryDressesSteps.verifyDressesBanner());
        //Step 5: Validate Dresses Text
        Assert.assertEquals(_categoryDressesSteps.verifyDressesText(), "Find your favorites dresses from our wide choice of evening, casual or summer dresses!");
        //Step 6: Validate Dresses Text 2
        Assert.assertEquals(_categoryDressesSteps.verifyDressesText2(), "We offer dresses for every day, every style and every occasion.");
        //Step 7: Validate Dresses 7 products
        Assert.assertEquals(_categoryDressesSteps.verifyDressesResults(), "There are 5 products.");
    }

    @Test(description = "Tests para probar la categoria T-shirts del proyecto final")
    public void testSR1012() {
        //Step 1: Abrir My Store
        _categoryTshirtsSteps.openMyStore();
        //Step 2: Click in Women Menu
        _categoryTshirtsSteps.clickTshirtsMenu();
        //Step 3: Validate Women category URL
        Assert.assertTrue(_categoryTshirtsSteps.verifyURLCategoryTshirts());
        //Step 4: Validate Women Banner
        Assert.assertTrue(_categoryTshirtsSteps.verifyTshirtsBanner());
        //Step 5: Validate Women Text
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsText(), "The must have of your wardrobe, take a look at our different colors,");
        //Step 6: Validate Women Text 2
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsText2(), "shapes and style of our collection!");
        //Step 7: Validate Women 7 products
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsResults(), "There is 1 product.");
    }
}
