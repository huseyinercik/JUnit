package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farkli test methodu olusturarak asagidaki gorevleri yapin
    1- Url in amazon icerdigini test edin
    2- titlenin facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gurundugunu test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.findElement(By.id("searchDropdownBox")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).sendKeys("Tire")
                .sendKeys(Keys.ENTER).perform();
       // String arananKelime = "amazon";
       //
       // String actualUrl = driver.getCurrentUrl();
       // Assert.assertTrue(actualUrl.contains(arananKelime));

    }

    @Test
    public void test02() {
        String istenmeyenKelime = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }

    @Test
    public void test03() {
        WebElement logoElementi = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
