package JUnitPractice.practice;

import JUnitPractice.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot2 extends TestBase {
    //Class : ScreenShot2

    @Test
    public void screenshotOfSpecificElements() {
        //Techpro education a git
        driver.get("https://techproeducation.com");
        //Sosyal medya elemanlarını goruntusunu al
        //1. ekran goruntusunu cek
        WebElement sosyalMedyaIkonlari = driver.findElement(By.xpath("(//div[@class='elementor-social-icons-wrapper elementor-grid'])[1]"));
        File image = sosyalMedyaIkonlari.getScreenshotAs(OutputType.FILE);

        //2. goruntuyu kaydet
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Logonun ekran goruntusunu al
        WebElement logo= driver.findElement(By.xpath("//a[@title='Online IT Courses']"));
        takeScreenshotOfElement(logo);
    }

}
