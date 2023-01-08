package egzersiz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class FluentWait1 extends TestBase {
    @Test
    public void fluentWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver
                .findElement(By.xpath("//div[@id='start']//button"))
                .click();
        //1.Fluent Wait icin obje olustur . Explicit waitten farki bu kisim
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//max bekleme suresi
                .pollingEvery(Duration.ofSeconds(3))//deneme araliklari
                .withMessage("IGNORE EXCEPTION")//mesaj yazdirabilirim. zorunlu degil
                .ignoring(NoSuchMethodException.class);//exception i handle et. Zorunlu degil


        //2. wait objesini kullanarak bekleme problemini coz
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText= helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

    }
}
