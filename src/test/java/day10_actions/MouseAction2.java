package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class MouseAction2 extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions action=new Actions(driver);
        WebElement dragMeElementi=driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHereElementi=driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        action.dragAndDrop(dragMeElementi,dropHereElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=droppedElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
