package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
        // isim kutusunu locate edip,
        WebElement isimElementi=driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        // geriye kalan alanlari TAB ile dolasarak
        Actions action=new Actions(driver);
        action.click(isimElementi).
                sendKeys("Huseyin").
                sendKeys(Keys.TAB).
                sendKeys("Ercik").
                sendKeys(Keys.TAB).
                sendKeys("huseyinercik@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("huseyinercik@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("huseyin1234!").
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
        // formu doldurun
    }
}
