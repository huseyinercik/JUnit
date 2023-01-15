package deneme;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class AutomationExercise extends TestBase {
    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement sayfaBasligi = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(sayfaBasligi.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement yeniKullaniciText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(yeniKullaniciText.isDisplayed());
        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//input[@data-qa='signup-name']"))
                .sendKeys("Huseyin",
                        Keys.TAB, "cercik1@gmail.com",
                        Keys.ENTER);

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        WebElement hesapBilgiText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(hesapBilgiText.isDisplayed());
        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
        Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.TAB,
                        Keys.TAB, "1234")
                .build()
                .perform();
        WebElement daysDdm = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(daysDdm);
        select.selectByVisibleText("2");
        WebElement mounthDdm = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 = new Select(mounthDdm);
        select1.selectByVisibleText("January");
        WebElement yearDdm = driver.findElement(By.xpath("//select[@id='years']"));
        Select select2 = new Select(yearDdm);
        select2.selectByVisibleText("1983");
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@id='first_name']"))
                .sendKeys(faker.name().firstName(),
                        Keys.TAB, faker.name().lastName(),
                        Keys.TAB, faker.company().name(),
                        Keys.TAB, faker.address().fullAddress(),
                        Keys.TAB, faker.address().city());
        WebElement countryDdm = driver.findElement(By.xpath("//select[@id='country']"));
        Select select3 = new Select(countryDdm);
        select3.selectByVisibleText("Canada");
        driver.findElement(By.xpath("id='state'")).sendKeys(faker.address().state(),
                Keys.TAB,faker.address().city(),
                Keys.TAB,faker.address().zipCode(),
                Keys.TAB,faker.phoneNumber().cellPhone(),
                Keys.ENTER);

        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam Et' düğmesini tıklayın
        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
    }

}
