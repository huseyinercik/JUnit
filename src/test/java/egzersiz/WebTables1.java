package egzersiz;

import JUnitPractice.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables1 extends TestBase {


    @Test
    public void table1print() {
        //https://the-internet.herokuapp.com/tables
        //Create a class: WebTables
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        //1.yol
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("table1 = " + table1);
        //2.yol
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement w : tumVeriler) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void row3Print() {
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 2 : 3. Row’ datalarını print edin
        //1.yol
        String row3 = driver.findElement(By.xpath("//table[@id='table1']//tr[3]")).getText();
        System.out.println("row3 = " + row3);
        //2.yol
        List<WebElement> row3List = driver.findElements(By.xpath("//table[@id='table1']//tr[3]//td"));
        row3List.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void sonSatirVerileri() {
        driver.get("https://the-internet.herokuapp.com/tables");

        printData(3, 4);

    }
    //Task 3 : Son row daki dataları print edin

    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

    public static void printData(int row, int column) {
        String sonuc = driver.findElement(By.xpath("//table[@id='table1']//tr[" + row + "]//td[" + column + "]")).getText();
        System.out.println("sonuc = " + sonuc);
    }
}
