package day13_cookies_webTables;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTesting() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        System.out.println(cookiesSet);
        int sayac = 1;
        for (Cookie w : cookiesSet
        ) {
            System.out.println(sayac + " incicookie" + w);
            System.out.println("name : " + w.getName());
            System.out.println("value :" + w.getValue());
            sayac++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookiesSet.size();
        Assert.assertTrue(cookieSayisi > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : cookiesSet
        ) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
                sayac++;
            }
        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);
        sayac = 1;
        cookiesSet = driver.manage().getCookies();
        for (Cookie w : cookiesSet
        ) {
            System.out.println(sayac + " incicookie" + w);

            sayac++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(cookie));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());

    }
}