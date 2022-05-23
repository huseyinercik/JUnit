package deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class deneme13 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Emir");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Ercik");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys("5025075254");


    }


}
