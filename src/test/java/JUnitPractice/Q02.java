package JUnitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02 {
     /*
   ...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
*/
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void testtenOnce(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        Assert.assertTrue("title best kelimesi icermiyor",driver.getTitle().contains("Best"));
    }
    @Test
    public void logoTest(){
        //WebElement logoBestBuy=driver.findElement(By.xpath("//img[@class=\"logo\"]"));
        WebElement helloHeading=driver.findElement(By.xpath("//div[@class=\"heading\"]"));
        WebElement logoBestBuy=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logoBestBuy.isDisplayed());
    }
    @Test
    public void mexicoLinkTesti(){
        WebElement usLink=driver.findElement(By.xpath("//img[@alt=\"United States\"]"));
        WebElement chooseYazisi=driver.findElement(By.xpath("//h1[.='Choose a country.']"));
        WebElement mexicoLink=driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }
    @After
    public void kapat(){
        driver.close();
    }
}
