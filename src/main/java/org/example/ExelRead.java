package org.example;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.poi.ss.usermodel.DateUtil.parseYYYYMMDDDate;

public class ExelRead {
    File file;
    Product product = null;
    ArrayList<Product> productArrayList = new ArrayList<>();


    public ExelRead(File file) {
        this.file = file;
    }

//    public void read() throws IOException {
//        FileInputStream fileIS = new FileInputStream(file);
//        Workbook workbook = new XSSFWorkbook(fileIS);
//        Sheet sheet = workbook.getSheetAt(0);
//        int i = 0;
//        for (Row row : sheet) {
//            data.put(i, new ArrayList<String>());
//            for (Cell cell : row) {
//                switch (cell.getCellType()) {
//                    case 1:
//                        data.get(i).add(cell.getRichStringCellValue().getString());
//                        break;
//                    case 0:
//                        DateUtil dateUtil = null;
//                        if (dateUtil.isCellDateFormatted(cell)) {
//                            Date dataData = cell.getDateCellValue();
//                            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
//                            data.get(i).add(formatForDateNow.format(dataData) + "");
//                        } else {
//                            int numericCellValue = (int) cell.getNumericCellValue();
//                            data.get(i).add(numericCellValue + "");
//                        }
//                        break;
//                    default:
//
//                        data.get(i).add(" ");
//                }
//            }
//            i++;
//        }
//        mapToArrayList();
//    }

    //читаем 0ый файл эксела в ArrayList<Product>
    public void readProduct() throws IOException {
        FileInputStream fileIS = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileIS);
        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for (Row row : sheet) {
            if (i > 4) {// нужные ячейки начинаются с 5 строки
                if (row.getCell(0).getRichStringCellValue().getString().equals("Итого")) break;
                //System.out.println("Обработка строки "+ i);
                product = new Product();
                product.setPoint(row.getCell(0).getRichStringCellValue().getString());
                product.setName(row.getCell(2).getRichStringCellValue().getString());
                Date dataData = row.getCell(3).getDateCellValue();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                product.setExpirationDate(formatForDateNow.format(dataData).toString());
                product.setSeries(row.getCell(4).getRichStringCellValue().getString());
                product.setQuantity((int) row.getCell(8).getNumericCellValue() + "");
                product.setPrice(row.getCell(7).getNumericCellValue() + "");
                productArrayList.add(product);

            }
            i++;
        }
    }

    //читаем 1ый файл эксела в ArrayList<Product>
    public void readProduct1() throws IOException {
        FileInputStream fileIS = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileIS);
        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for (Row row : sheet) {
            if (i > 4) {// нужные ячейки начинаются с 5 строки
                if (row.getCell(0).getRichStringCellValue().getString().equals("Итого")) break;
                // System.out.println("Обработка строки "+ i);
                product = new Product();
                product.setPoint(row.getCell(0).getRichStringCellValue().getString());
                product.setName(row.getCell(2).getRichStringCellValue().getString());
                Date dataData = row.getCell(3).getDateCellValue();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                product.setExpirationDate(formatForDateNow.format(dataData).toString());
                product.setSeries(row.getCell(4).getRichStringCellValue().getString());
                product.setQuantity1((int) row.getCell(8).getNumericCellValue() + "");
                product.setPrice(row.getCell(7).getNumericCellValue() + "");
                productArrayList.add(product);

            }
            i++;
        }
    }

    //читаем 2ый файл эксела в ArrayList<Product>
    public void readProduct2() throws IOException {
        FileInputStream fileIS = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileIS);
        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for (Row row : sheet) {
            if (i > 4) {// нужные ячейки начинаются с 5 строки
                if (row.getCell(0).getRichStringCellValue().getString().equals("Итого")) break;
                // System.out.println("Обработка строки "+ i);
                product = new Product();
                product.setPoint(row.getCell(0).getRichStringCellValue().getString());
                product.setName(row.getCell(2).getRichStringCellValue().getString());
                Date dataData = row.getCell(3).getDateCellValue();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                product.setExpirationDate(formatForDateNow.format(dataData).toString());
                product.setSeries(row.getCell(4).getRichStringCellValue().getString());
                product.setQuantity2((int) row.getCell(8).getNumericCellValue() + "");
                product.setPrice(row.getCell(7).getNumericCellValue() + "");
                productArrayList.add(product);

            }
            i++;
        }
    }

    //читаем 3ый файл эксела в ArrayList<Product>
    public void readProduct3() throws IOException {
        FileInputStream fileIS = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileIS);
        Sheet sheet = workbook.getSheetAt(0);
        int i = 0;
        for (Row row : sheet) {
            if (i > 4) {// нужные ячейки начинаются с 5 строки
                if (row.getCell(0).getRichStringCellValue().getString().equals("Итого")) break;
                // System.out.println("Обработка строки "+ i);
                product = new Product();
                product.setPoint(row.getCell(0).getRichStringCellValue().getString());
                product.setName(row.getCell(2).getRichStringCellValue().getString());
                Date dataData = row.getCell(3).getDateCellValue();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                product.setExpirationDate(formatForDateNow.format(dataData).toString());
                product.setSeries(row.getCell(4).getRichStringCellValue().getString());
                product.setQuantity3((int) row.getCell(8).getNumericCellValue() + "");
                product.setPrice(row.getCell(7).getNumericCellValue() + "");
                productArrayList.add(product);

            }
            i++;
        }
    }

    static public void safe(ArrayList<Product> data, String str1, String str2, String str3, String str4) throws ParseException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NN");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Пункт");
        row.createCell(2).setCellValue("Серия");
        row.createCell(3).setCellValue("Срок годности");
        row.createCell(4).setCellValue("цена");
        row.createCell(5).setCellValue(str1);
        row.createCell(6).setCellValue(str2);
        row.createCell(7).setCellValue(str3);
        row.createCell(8).setCellValue(str4);

        rowNum = 1;

        for (Product product : data) {
            Row row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(product.getName());
            row1.createCell(1).setCellValue(product.getPoint());
            row1.createCell(2).setCellValue(product.getSeries());
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
            String[] split = product.getExpirationDate().split("\\.");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[2]), Integer.parseInt(split[1])-1, Integer.parseInt(split[0]));
            row1.createCell(3).setCellValue(calendar);
            row1.createCell(4).setCellValue(Double.parseDouble(product.getPrice()));
            if (product.getQuantity() == null) row1.createCell(5).setCellValue(0);
            else row1.createCell(5).setCellValue(Integer.parseInt(product.getQuantity()));
            if (product.getQuantity1() == null) row1.createCell(6).setCellValue(0);
            else row1.createCell(6).setCellValue(Integer.parseInt(product.getQuantity1()));
            if (product.getQuantity2() == null) row1.createCell(7).setCellValue(0);
            else row1.createCell(7).setCellValue(Integer.parseInt(product.getQuantity2()));
            if (product.getQuantity3() == null) row1.createCell(8).setCellValue(0);
            else row1.createCell(8).setCellValue(Integer.parseInt(product.getQuantity3()));
            rowNum++;
        }

        File file1 = new File(
                "C:\\анализ срока годности\\Итоговые отчеты\\общая 06.07.2023 ФЗ.xls");
        try (FileOutputStream out = new FileOutputStream
                (file1)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан! " + file1.toString());
    }
}

