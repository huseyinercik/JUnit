package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //bana icinde bulundugum projenin dosya yolunu (path) verir
        //C:\Users\W10\IdeaProjects\com.Batch59JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\W10 yani benim bilgisayarimin bana ozel kismini verdi

        //C:\Users\W10\Downloads

        //homePath +"/Download"

        //C:\Users\W10\Desktop
        //C:\Users\W10\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit

        //Masa ustumuzdeki text dosyasinin varligini test edin
        //C:\Users\W10\Desktop\text.txt
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
        javada dosyaya erisim icin dosya yoluna yani path e ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan masa ustu
        dosya yoluda birbirinden farkli olacaktir
        testlerimizin tum bilgisayarlarda calismasi icin
        dosya yolunu DINAMIK yapmak zorundayiz
        */

        //bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim=System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";
        //mac icin "/Dekstop/text"

        String masaUstuDosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));



    }
}
