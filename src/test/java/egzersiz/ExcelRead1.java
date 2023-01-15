package egzersiz;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelRead1 {

    @Test
    public void readExcelTest() throws IOException {
        //WORKBOOK(EXCEL DOSYASI)>wORKSHEET/SHEET>ROW(SATIR)>CELL(VERI HUCRESI)
        String path = "src/test/java/resources/Capitals.xlsx";

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC/ WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        // SAYFAYI AC/SHEET1
        //    Sheet sheet1=workbook.getSheetAt(0);//index 0 dan baslar .ilk sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sheet1");//Sheet 1 isimli sayfayi ac


        //ILK SATIRA GIT/ROW
        Row row1 = sheet1.getRow(0);//ilk satira git

        //ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);


        // O VEROYI YAZDIr
        System.out.println(cell1);

        //1 SATIR 2. SUTUN

        Cell cell12= sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        //        3.Satir 1.Sutun yazdir ve O verinin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //Exceldeki toplam kullanilan satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satir numarasi .index 0 dan basliyor .sayma sayilari
        System.out.println(toplamSatirSayisi);//11

        //Kullanilan toplam satir sayisi

        int kullnilanToplamSatirSayisi=sheet1.getPhysicalNumberOfRows();
        System.out.println(kullnilanToplamSatirSayisi);// 1 den basliyor

        //COUNTRY,CAPITALS key vevalue lari map a alip print et

        //{{USA,D.C},{france<paris},....}

        //Variable olusturalim bu variable exceldeki country,capital verilerini tutatcak

        Map<String,String>ulkeBaskentleri=new HashMap<>();

        for (int satirSayisi=1;satirSayisi<kullnilanToplamSatirSayisi;satirSayisi++){
            String country=sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital=sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println("ulkeBaskentleri = " + ulkeBaskentleri);
    }
}
