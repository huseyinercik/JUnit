package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //facebook gorevini fake isimlerle yapalim
        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
        // isim kutusunu locate edip,
        WebElement isimElementi=driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        // geriye kalan alanlari TAB ile dolasarak
        Actions action=new Actions(driver);
        Faker faker = new Faker();
        String fakeMail=faker.internet().emailAddress();
        action.click(isimElementi).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(fakeMail).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Eyl").
                sendKeys(Keys.TAB).
                sendKeys("1983").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).


                perform();

        Thread.sleep(10000);
    }
}
