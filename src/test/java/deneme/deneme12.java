package deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class deneme12 extends TestBase {
    @Test
    public void test01() {
      //Test01
        //:
        //1
        //amazon gi din
        driver.get("https://www.amazon.com");
        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownElemnt=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select=new Select(dropDownElemnt);
        System.out.println(dropDownElemnt.getText());
        //3 drop down menude 40 eleman olduğunu doğrulayın
        List<WebElement> ddmliste=select.getOptions();
        int actualOptionSayisi=ddmliste.size();
        int expectedSayi=28;
        Assert.assertEquals(actualOptionSayisi,expectedSayi);
        //T
        //est02
        //1 dropdown menuden elektronik bölümü seç in
        select.selectByVisibleText("Electronics");
        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
        WebElement iphoneSonuc=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        System.out.println("iphoneSonuc = " + iphoneSonuc.getText());
        //3
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedYazi="iphone";
        String actualYazi=iphoneSonuc.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));
        //4 ikinci ürüne relative locater kullanarak tıklay in
        WebElement iphoneUrun=driver.findElement(By.xpath("(//img[@class=\"s-image\"])[2]"));
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunTitle=driver.getTitle();
        String urunFiyat=driver.findElement(By.xpath("//input[@class=\"a-button-input\"]")).getText();
        System.out.println("urunTitle = " + urunTitle);
        System.out.println("urunFiyat = " + urunFiyat);
        iphoneUrun.click();
        driver.findElement(By.xpath("//a[@class=\"a-button-text a-text-left\"]")).click();

        //T
        //est03
        //1 yeni bir sekme açarak amazon a nasayfaya gid in
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2 dropdown’dan bebek bölümüne secin
        WebElement ikinciddm=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select2=new Select(ikinciddm);
        select2.selectByVisibleText("Baby");
        //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puset"+Keys.ENTER);
        //4 sonuç yazsının puset içerdiğini te st edin
        //5 üçüncü ürüne relative locater kullanarak tıklay in
        //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in
        //Test 4
        //1
        //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }


}
