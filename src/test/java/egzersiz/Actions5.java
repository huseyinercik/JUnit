package egzersiz;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions5 extends TestBase {



    @Test
    public void test01(){
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        Actions actions=new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.name("q"));
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusu uzerinde Shift tusuna bas
                .sendKeys("iPhone X fiyatlari")//shift e basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift e artik basma
                .sendKeys(" cok pahali!",Keys.ENTER)//normal halde yaz ve enter tusuna bas
                .build()//birden fazla actions methodu kullanildiginda build();( yapiyi olusturmak guclendirmek) icinkullanilmasi onerilir
                .perform();
        waitFor(5);


        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

    }
}
