import Steps.CategoryDressesSteps;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CategoryDressesTest extends BaseTest{
    CategoryDressesSteps _categoryDressesSteps = new CategoryDressesSteps(webDriver);

    @Test(description = "Test del Requerimiento SR1011, Menú Dresses")
    public void SR1011(){
        //Step 1: Abrir My Store
        _categoryDressesSteps.openMyStore();
        //Step 2: Click in Dresses Menu
        _categoryDressesSteps.clickDressesMenu();
        //Step 3: Validate Dresses category URL
        Assert.assertTrue(_categoryDressesSteps.verifyURLCategoryDresses());
        //Step 4: Validate Dresses Banner
        Assert.assertTrue(_categoryDressesSteps.verifyDressesBanner());
        //Step 5: Validate Dresses Text
        Assert.assertEquals(_categoryDressesSteps.verifyDressesText(),"Find your favorites dresses from our wide choice of evening, casual or summer dresses!");
        //Step 6: Validate Dresses Text 2
        Assert.assertEquals(_categoryDressesSteps.verifyDressesText2(),"We offer dresses for every day, every style and every occasion.");
        //Step 7: Validate Dresses 7 products
        Assert.assertEquals(_categoryDressesSteps.verifyDressesResults(),"There are 5 products.");
    }
}
