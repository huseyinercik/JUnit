package deneme;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class deneme7 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1.
        //Yeni bir class olusturalim (Homework)
        //2.
        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String istenenTitle="facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenenTitle));
        //3.
        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String istenenUrlKelime="facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenUrlKelime));
        //4.
        //https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");
        //5.
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedTitle="Walmart.com";
        String actual2Title=driver.getTitle();
        Assert.assertTrue(actual2Title.contains(expectedTitle));
        //6.
        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7.
        //Sayfayi yenileyin
        driver.navigate().refresh();
        //8.
        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        //9.
        //Browser’i kapatin
    }
}
