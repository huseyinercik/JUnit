package JUnitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.spec.KeySpec;
import java.time.Duration;

public class Q04 {
    /*
   ...Exercise4...
   https://www.teknosa.com/ adresine gidiniz
   arama cubuguna oppo yazip enter deyiniz
   sonuc sayisini yazdiriniz
   cikan ilk urune tiklayiniz
   sepete ekleyiniz
   sepetime git e tiklayiniz
   consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
   Alisverisi tamamlayiniz
   son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
   driver i kapatiniz

*/
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.teknosa.com");

        ChromeOptions op=new ChromeOptions();
        op.addArguments("disable-popup-blocking");
        WebElement searchArea=driver.findElement(By.xpath("//input[@id=\"search-input\"]"));
        searchArea.sendKeys("Oppo"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class=\"plp-info\"]")).getText());

        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        driver.findElement(By.xpath("(//button[@id=\"addToCartButton\"])[1]")).click();
        driver.findElement(By.xpath("//a[@class=\"btn btn-secondary\"]")).click();
        System.out.println("siparis ozeti yazisi: "+driver.findElement(By.xpath("//div[@class=\"cart-sum-title\"]")).getText());

        driver.findElement(By.xpath("//span[.='Alışverişi Tamamla']")).click();
        System.out.println("hosgeldiniz yazisi :" +driver.findElement(By.xpath("//div[text()= 'Teknosa’ya hoş geldiniz']")).getText());
        driver.close();
    }
}
