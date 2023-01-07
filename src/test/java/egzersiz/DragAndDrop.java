package egzersiz;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class DragAndDrop extends TestBase {
    //En cok kullanilan dragAndDrop methodudur
    @Test
    public void dragAndDrop(){
        //Class: Action4
        //Method: dragAndDropTest


        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedef= driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions
                .dragAndDrop(kaynak,hedef)
                 .perform();
        waitFor(5);
    }

    @Test
    public void clickAndHoldTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//kaynagi tut
                .moveToElement(hedef)//hedefe koy
                .release()//kaynagi birak
                .build()//oceki methodlarin iliskisini kur/guclendir. KULLANILMASI TERCIH EDILIR
                .perform();//islemi gerceklestir
        waitFor(3);
    }

    @Test
    public void moveByOffSetTest() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)
                .moveByOffset(430,30)
                .release()
                .build()
                .perform();
        waitFor(3);
    }
}
