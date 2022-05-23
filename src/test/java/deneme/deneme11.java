package deneme;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class deneme11 extends TestBase {
    @Test
    public void test01() {
        //1 ) Bir class oluşturun : Locators_css
        //2
        //Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        //b. Locate email textbox
        WebElement eMailElementi=driver.findElement(By.cssSelector("input[name=\"session[email]\"]"));
        //c. Locate password textbox ve
        WebElement passwordElementi=driver.findElement(By.cssSelector("input[name=\"session[password]\"]"));
        //d. Locate signin button
        WebElement signinElementi=driver.findElement(By.cssSelector("input[name=\"commit\"]"));
        //e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini
        //tıklayın
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        eMailElementi.sendKeys("testtechproed@gmail.com");
        passwordElementi.sendKeys("Test1234!");
        signinElementi.click();
        //NOT: cssSelector kullanarak elementleri locate ediniz.
    }
}
