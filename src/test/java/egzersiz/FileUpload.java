package egzersiz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FileUpload extends TestBase {
    @Test
    public void fileUploadTest() {

        //Tests packagenin altina bir class oluşturun : C05_UploadFile

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        /*
        chooseFilebutton una yuklemek istedigim dosyanin path gondererek dosyayi sectim
         */
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

        //Upload butonuna basalim.
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadYazisi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadYazisi);
        waitFor(5);

    }
}
