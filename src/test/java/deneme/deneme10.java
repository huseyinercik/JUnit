package deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class deneme10 extends TestBase {
    @Test
    public void test01() {
        //1
        //https://the internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2
        //Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        //3
        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonElementi=driver.findElement(By.xpath("//button[@onclick=\"deleteElement()\"]"));
        Assert.assertTrue(deleteButonElementi.isDisplayed());
        //4
        //Delete tusuna basin
        deleteButonElementi.click();
        //5
        //Add/Remove Elements ” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(addRemoveElement.isDisplayed());;
    }
}
