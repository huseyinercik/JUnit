package egzersiz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitWait  extends TestBase {
    //
     @Test
    public void explicitWaitTest(){

         driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
         driver.findElement(By.xpath("//div[@id='start']//button")).click();
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
         WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
         String helloWorldText= helloWorldElement.getText();
         Assert.assertEquals("Hello World!",helloWorldText);
     }

}
