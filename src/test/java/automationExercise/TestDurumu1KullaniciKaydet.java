package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestDurumu1KullaniciKaydet {
    WebDriver driver;

    @Before
    public void setup() {
        //1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        //driver.close();
    }

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(expectedTitle, actualTitle);

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement yeniKullaniciText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullaniciText.isDisplayed());

        //6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Huseyin");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("huseyin7@gmail.com");

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        WebElement hesapBilgisiText = driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        Assert.assertTrue(hesapBilgisiText.isDisplayed());

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234");

        WebElement ddmGun = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(ddmGun);
        select.selectByVisibleText("15");

        WebElement ddmAy = driver.findElement(By.xpath("//*[@id='months']"));
        Select select1 = new Select(ddmAy);
        select1.selectByVisibleText("January");

        WebElement ddmYil = driver.findElement(By.xpath("//*[@id='years']"));
        Select select2 = new Select(ddmYil);
        select2.selectByVisibleText("1983");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        WebElement onay = driver.findElement(By.xpath("//*[@id='newsletter']"));
        if (!onay.isDisplayed()) {
            onay.click();
        }
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        WebElement onay2 = driver.findElement(By.xpath("//*[@id='optin']"));
        if (!onay2.isSelected()) {
            onay2.click();
        }
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Huseyin");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Ercik");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Techpro");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Mehmet Akif Ersoy mah");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("199 sok");
        WebElement ddmUlke = driver.findElement(By.xpath("//*[@id='country']"));
        Select select3 = new Select(ddmUlke);
        select3.selectByVisibleText("Canada");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Saricam");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Adana");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("0120");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("05325550961");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement hesapOlustuYazisi = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(hesapOlustuYazisi.isDisplayed());

        //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
            WebElement kullaniciAdiGorunur=driver.findElement(By.xpath("//*[@class='fa fa-user']"));
            Assert.assertTrue(kullaniciAdiGorunur.isDisplayed());
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[1]")).click();
        //18.Tekrardan  'Yeni Kullanıcı Kaydı' metninin gorundugunu  doğrulayın!
        WebElement yeniKullaniciText1 = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullaniciText1.isDisplayed());

    }
}
