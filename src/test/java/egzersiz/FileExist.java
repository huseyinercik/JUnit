package egzersiz;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist {
    //masa ustunde bir dosyanin varligini test edin
    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println("userDIR = " + userDIR);

        String userHOME = System.getProperty("user.home");
        System.out.println("userHOME = " + userHOME);

        //logo.jpeg indirip MASAUSTUNE kaydedin
        //Logo masaustunde:C:\Users\Asus\Masaustu
        String dosyaYolu = userHOME + "/Desktop/logo.jpeg";
        System.out.println("dosyaYolu = " + dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosya var ise true , yoksa false
        System.out.println("isExist = " + isExist);

        Assert.assertTrue(isExist);

        /*
        1. fail -> dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }
}
