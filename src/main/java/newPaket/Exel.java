package newPaket;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Exel {
    File file;
    Product product;
    ArrayList<Product> pr = new ArrayList<>();

    public Exel(File file) {
        this.file = file;
    }

    public ArrayList<Product> readExel() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int num = 0;
        for (Row row : sheet) {
            if (num > 4) {
                if (row.getCell(0).getRichStringCellValue().getString().equals("Итого")) break;
                product = new Product();
                product.setPunkt(row.getCell(0).getRichStringCellValue().getString());
                product.setName(row.getCell(2).getRichStringCellValue().getString());
                Date dataData = row.getCell(3).getDateCellValue();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                String data = formatForDateNow.format(dataData);
                String[] split = data.split("\\.");
                Calendar calendar = new GregorianCalendar(Integer.parseInt(split[2]),
                        Integer.parseInt(split[1]) - 1, Integer.parseInt(split[0]));
                product.setSrokGodnosti(calendar);
                product.setSeria(row.getCell(4).getRichStringCellValue().getString());
                product.setKol((int) row.getCell(8).getNumericCellValue());
                product.setPrice(row.getCell(7).getNumericCellValue());
                pr.add(product);
            }
            num++;
        }
        return pr;
    }

    public  static void saveExel(ArrayList<Product> data, String[] str) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NN");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Пункт");
        row.createCell(2).setCellValue("Серия");
        row.createCell(3).setCellValue("Срок годности");
        row.createCell(4).setCellValue("цена");
        row.createCell(5).setCellValue(str[0]);
        row.createCell(6).setCellValue(str[1]);
        row.createCell(7).setCellValue(str[2]);
        row.createCell(8).setCellValue(str[3]);

        rowNum = 1;
        for (Product product : data) {
            Row row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(product.getName());
            row1.createCell(1).setCellValue(product.getPunkt());
            row1.createCell(2).setCellValue(product.getSeria());
            row1.createCell(3).setCellValue(product.getSrokGodnosti());
            row1.createCell(4).setCellValue(product.getPrice());
            row1.createCell(5).setCellValue(product.getKol());
            row1.createCell(6).setCellValue(product.getKol1());
            row1.createCell(7).setCellValue(product.getKol2());
            row1.createCell(8).setCellValue(product.getKol3());
            rowNum++;
        }

        File file1 = new File(
                "C:\\анализ срока годности\\Итоговые отчеты\\общая 13.07.2023 ССЗ.xls");
        try (FileOutputStream out = new FileOutputStream
                (file1)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!!!! " + file1.toString());
    }

    public  ArrayList<Product> listDelPovtor(ArrayList<Product> pr) {
        /*
       убирает одинаковые товары, суммируя их по количеству
       ArrayList<Product> pr исходная коллекция
       ArrayList<Product> prNew новая коллекция
         */
        ArrayList<Product> prNew = new ArrayList<>();
        for (int i = 0; i < pr.size(); i++) {
            if (prNew.contains(pr.get(i))) {
                for (int j = 0; j < prNew.size(); j++) {
                    if (pr.get(i).equals(prNew.get(j))) {
                        int temp = pr.get(i).getKol() + prNew.get(j).getKol();
                        prNew.get(j).setKol(temp);
                    }
                }
            } else prNew.add(pr.get(i));
        }
        return prNew;
    }

}
