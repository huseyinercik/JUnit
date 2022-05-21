package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.



    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @AfterClass
    public static void tearDown() {
       driver.close();
    }
    @Test
    public void acceptAlert(){
        //● Bir metod olusturun: acceptAlert
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //        “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        driver.switchTo().alert().accept();
        String expectedResultYazisi="You successfully clicked an alert";
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualResultYazisi=sonucYazisiElementi.getText();
        Assert.assertEquals(expectedResultYazisi,actualResultYazisi);


    }@Test
    public void dismissAlert(){
        //● Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfuly";
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualResultYazisi=sonucYazisiElementi.getText();
        Assert.assertFalse(istenmeyenKelime.contains(actualResultYazisi));

    }@Test
    public void sendKeysAlert() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        driver.switchTo().alert().sendKeys("Emir Ercik");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String girilenIsim="Emir Ercik";
        Assert.assertTrue(sonucYazisiStr.contains(girilenIsim));

    }

}
