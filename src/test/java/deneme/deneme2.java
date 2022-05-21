package deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deneme2 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        WebElement ilkUrunResmi = driver.findElement(By.xpath("//div[@class=\"a-section aok-relative s-image-square-aspect\"][1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class=\"a-section aok-relative s-image-square-aspect\"][1]")).click();
        WebElement urunTitle = driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(urunTitle.getText());
        driver.switchTo().window(ilkSayfaHandleDegeri);
       String url=driver.getCurrentUrl();
        System.out.println(url);
    }

}
