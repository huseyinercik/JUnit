package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_Actions extends TestBase {
    /*
    ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;
     */


    /*
    1- Actions nedir?
*Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard
işlemlerini gerçekleştirmek icin kullandigimiz hazır bir
selenium kütüphanesidir. Ornegin, sag tiklqmqk(contextClick) ,
çift tıklamak(doub1eClick), elementin uzerine
gitmek(moveToElement) gibi mouse işlemlerini
gerçekleştirebiliriz. Ayni zamanda, shift, control, delete,
enter gibi keyboard tuşlar.inada actions yardımıyla basabiliriz.
Bu tur işlemlerde sendKeys metodu kullanilir
     */

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
