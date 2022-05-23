package deneme;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class deneme8 extends TestBase {
    @Test
    public void test01() {
        //1. Bir class oluşturun: LoginTest
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();
        //c
        //. email textbox,password textbox, and signin button elementlerini locate
        WebElement eMailTextBoxElementi=driver.findElement(By.id("session_email"));
        WebElement passwordTextBoxElementi=driver.findElement(By.id("session_password"));
        WebElement signinButonElementi=driver.findElement(By.name("commit"));

        //d
        //. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
        //i. Username :
        //testtechproed@gmail.com
        //ii. Password : Test1234!
        eMailTextBoxElementi.sendKeys("testtechproed@gmail.com");
        passwordTextBoxElementi.sendKeys("Test1234!");
        signinButonElementi.click();
        //e. Expected user id nin
        //testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUserId="testtechproed@gmail.com";
        WebElement actualUserId=driver.findElement(By.className("navbar-text"));
        Assert.assertTrue(expectedUserId.contains(actualUserId.getText()));
        //f
        //. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses = driver.findElement(By.xpath("//a[@data-test=\"addresses\"]"));
        Assert.assertTrue(addresses.isDisplayed());
        WebElement signOut=driver.findElement(By.xpath("//a[@class=\"nav-item nav-link\"]"));
        Assert.assertTrue(signOut.isDisplayed());
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkListesi=driver.findElements(By.tagName("a"));
        System.out.println("linkListesi = " + linkListesi.size());

    }
}
