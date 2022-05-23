package deneme;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import utilities.TestBase;

public class deneme6 extends TestBase {
    @Test
    public void manageMethhod() throws InterruptedException {
        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        driver.manage().window().getPosition();
        driver.manage().window().getSize();
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(80,50));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(450,500));
        Thread.sleep(3000);

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        //8
        //. Sayfayi kapatin

    }
}
