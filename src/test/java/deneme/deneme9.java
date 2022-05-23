package deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class deneme9 extends TestBase {
    @Test
    public void test01() {
        //1. Bir class oluşturun :
        //AmazonSearchTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a
        //.web sayfasına gidin. https:// amazon .
        driver.get("https://www.amazon.com");
        //b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike"+ Keys.ENTER);
        //c.
        //Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
        System.out.println(driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText());
        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("//img[@class=\"s-image\"][1]")).click();
    }
}
