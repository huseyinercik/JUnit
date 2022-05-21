package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //amazon ana syfaya gidip
        //Account menusunden create a list linkine tiklayalim
        driver.get("https://www.amazon.com");
        Actions action = new Actions(driver);
        WebElement accountLinki=driver.findElement(By.xpath("//*[text()='Create a List']"));
        action.moveToElement(accountLinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);

    }
}