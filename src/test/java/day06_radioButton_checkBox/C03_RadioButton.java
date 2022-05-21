package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    //-https://www.facebook.com adresine gidin
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //-“radio buttons” elementlerini locate edin
        WebElement felameButton =driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton =driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton =driver.findElement(By.xpath("//input[@value='-1']"));
        //-Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(3000);
        felameButton.click();
        Thread.sleep(3000);
        customButton.click();
    }
}
