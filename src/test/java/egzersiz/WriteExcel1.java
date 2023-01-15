package egzersiz;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel1 {

    @Test
    public void writeExcelTest() throws IOException {
        //WORKBOOK > SHEET > ROW > CELL > YAZ > KAYDET
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

        //ILK SATIR 3. SUTUNU CREATE ET
        Cell  cell3 = row1.createCell(2);

        //NUFUS YAZ
        cell3.setCellValue("NUFUS");

        //        2. satir 3. sutuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

//        3. satir 3. sutuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        //KAYDET: KAYDETME ISLEMI FileOutputStream ile yapilir
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);



    }
}
