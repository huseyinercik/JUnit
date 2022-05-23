package deneme;

import org.junit.Test;
import utilities.TestBase;

public class deneme4 extends TestBase {
    @Test
    public void navigationMethod() {
        //1. Yeni bir Class olusturalim.C05_NavigationMethods
        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        //5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        //7
        //. Sayfayi kapatalim / Tum sayfalari kapatalim
    }
}
