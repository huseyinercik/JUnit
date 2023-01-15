package egzersiz;

import JUnitPractice.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot1 extends TestBase {
    /*
    Seleniumda tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen getScreenshotAs() methodu ile alinir
    -getScreenshotAs() methodu seleniumdaki TakesScreenshot api indan gelir
     */
    @Test
    public void fullPageScreenshotTest() throws IOException {
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");

        //1. ekran goruntusunu getScreenshotAs() methoduyla alip File olarak olusturalim
        File goruntu=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2. almis oldugum ekran goruntusunu belirledigim bir path e kaydet .dir = directory = dosya
        // note= kayit ismini dinamik yapmak icin date objesi kullandim
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);

        //3. goruntu ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

        // Alternatif olarak tum adimlari tek seferde degisken kullanmadan olusturma
       // FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
       //         new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));


        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expectedText="Search Results for: QA";
        String actualText=driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expectedText.contains(actualText));

        //Reusable method yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();
    }
}
