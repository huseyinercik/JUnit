package day09_handleWindows_testBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;
public class C03_windowHandles {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(100);
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi= driver.findElement(By.xpath("//h3"));
        Thread.sleep(100);

        String expectedYazi="Opening a new window";
        Thread.sleep(100);

        String actualYazi=sayfadakiYaziElementi.getText();
        Thread.sleep(100);

        Assert.assertEquals(expectedYazi, actualYazi);
        Thread.sleep(100);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        Thread.sleep(100);

        String actualTitle= driver.getTitle();
        Thread.sleep(100);

        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(100);

        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        Thread.sleep(100);

        System.out.println(ilkSayfaWindowHandleDegeri);
        Thread.sleep(100);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(100);


          /*switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin woindow handle degeridir deriz
         */
        Set<String> windowHandleseti= driver.getWindowHandles();
        Thread.sleep(100);

        System.out.println(windowHandleseti);
        Thread.sleep(100);

        String ikinciSayfaWindowHandleDegeri="";
        Thread.sleep(100);

        for (String each: windowHandleseti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
        Thread.sleep(100);

        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        Thread.sleep(100);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedIkinciTitle="New Window";
        Thread.sleep(100);

        String actualIkinciTitle= driver.getTitle();
        Thread.sleep(100);

        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);
        Thread.sleep(100);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi=driver.findElement(By.xpath("//h3"));
        Thread.sleep(100);

        String expectedIkinciYazi="New Window";
        Thread.sleep(100);

        String actualIkinciYazi= ikinciSayfaYaziElementi.getText();
        Thread.sleep(100);

        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);
        Thread.sleep(100);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        Thread.sleep(100);

        expectedTitle="The Internet";
        Thread.sleep(100);

        actualTitle= driver.getTitle();
        Thread.sleep(100);

        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(100);

    }
}
