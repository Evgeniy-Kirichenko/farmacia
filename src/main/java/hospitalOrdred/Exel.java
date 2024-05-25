package hospitalOrdred;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Exel {
    public static ArrayList<Model> readFileExel(File file) throws IOException {//читает файл и создает ArrayList<Model>
        ArrayList<Model> product = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int num = 0;
        for (Row row : sheet) {
            if (num >= 1) {
                Model model = new Model();
                int quantityNumeric = 0;
                double quantityOrder = 0;
                double quantityRelease = 0;
                int a = 0;
                String s = row.getCell(7).getRichStringCellValue().getString();//наименование
                quantityOrder = row.getCell(6).getNumericCellValue();// количество выписанное
                quantityRelease = row.getCell(8).getNumericCellValue();// отпущенное количество
                String division = row.getCell(13).getRichStringCellValue().getString();


                if (!s.contains("№")) { //если наименование не содержит №, то наименование не делим, quantityNumeric = 1
                    model.setName(s);
                    model.setOrderedQuantity(quantityOrder);
                    model.setReleasedQuantity(quantityRelease);
                    model.setDivision(division);
                    model.setNumericQuantity(1);
                } else {
                    /*Если наименование содержит №, то делим на две части по №. Во второй части остается "50 , ооооооо"
                    Первая часть это наименование
                    Вторую часть делим по запятой, берем первую часть и убираем пробелы. Потом переводим в число
                    и сохраняем в quantityNumeric*/
                    String[] str1 = new String[]{s.split("№")[0], s.split("№")[1]};
                    quantityNumeric = textNumeric(str1[1]);

                    model.setName(str1[0]);
                    model.setOrderedQuantity(quantityNumeric * quantityOrder);
                    model.setReleasedQuantity(quantityNumeric * quantityRelease);
                    model.setDivision(division);
                    model.setNumericQuantity(quantityNumeric);
                }
                // if (model.getOrderedQuantity() == 0)
                 System.out.println("строка №" + num + " " + model.getName() + " " + model.getOrderedQuantity());
                product.add(model);
                num++;

            } else num++;
        }
        System.out.println("файл прочитан и содержит " + product.size() + " записей");
        return product;
    }

    private static int textNumeric(String str) {//выделяет количество таблеток в упаковке
        int numeric = 0;
        String str3;
        //убираем начальные и конечные пробелы
        String str1 = str.trim();
        //оставляем от этой строки(str1) первые три позиции
        int len = Math.min(str1.length(), 3);
        String str2 = str1.substring(0, len);
        if (str2.contains(",")) {
            str3 = str2.split(",")[0].trim();
        } else if (str2.contains(" ")) {
            str3 = str2.split(" ")[0];
        } else if (str2.contains(".")) {
            str3 = str2.split(".")[0];
        } else str3 = str2;
        numeric = Integer.parseInt(str3);
        return numeric;
    }

    public static ArrayList<Model> summaZakupkiPoNaimenovaniy(ArrayList<Model> origin) {
      /*
       убирает одинаковые товары, суммируя их по количеству
       ArrayList<Model> pr исходная коллекция
       ArrayList<Model> prNew новая коллекция
         */
        ArrayList<Model> originNew = new ArrayList<>();
        for (int i = 0; i < origin.size(); i++) {
            if (originNew.contains(origin.get(i))) {
                for (int j = 0; j < originNew.size(); j++) {
                    if (origin.get(i).equals(originNew.get(j))) {
                        double tempOrderedQuantity = origin.get(i).getOrderedQuantity() + originNew.get(j).getOrderedQuantity();
                        originNew.get(j).setOrderedQuantity(tempOrderedQuantity);
                        double tempReleasedQuantity = origin.get(i).getReleasedQuantity() + originNew.get(j).getReleasedQuantity();
                        originNew.get(j).setReleasedQuantity(tempReleasedQuantity);
                    }
                }
            } else originNew.add(origin.get(i));
        }
        System.out.println("Список обработан. Было " +origin.size()+"### Стало "+ originNew.size() );
        return originNew;
    }

    public static void saveExel(ArrayList<Model> listSave, String file){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NN");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Заказанное кол-во №1");
        row.createCell(2).setCellValue("Отпущенное кол-во №1");
        row.createCell(3).setCellValue("Подразделение");

        rowNum = 1;
        for (Model model : listSave) {
            Row row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(model.getName());
            row1.createCell(1).setCellValue(model.getOrderedQuantity());
            row1.createCell(2).setCellValue(model.getReleasedQuantity());
            row1.createCell(3).setCellValue(model.getDivision());
            rowNum++;
        }
        File file1 = new File(file);

        try (FileOutputStream out = new FileOutputStream
                (file1)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан! " + file1.toString());

    }
}
