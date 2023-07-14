package kolichestvoProdag;

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


    public static ArrayList<Model> reedExel(File file) throws IOException {
        ArrayList<Model> product = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int num = 0;
        String lgota = "";
        for (Row row : sheet) {
            String str = row.getCell(0).getRichStringCellValue().getString();
            if (str.equals("Итого")) {
                num++;
                continue;
            }
            if (str.equals("Федеральный")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Без льготы")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Федеральный (наркотики)")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Федеральный (выс-затратные)")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Региональный")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("ССЗ")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Региональный (наркотики)")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Паллиативный")) {
                lgota = str;
                num++;
                continue;
            }
            if (str.equals("Паллиативный (сильнодействующий)")) {
                lgota = str;
                num++;
                continue;
            }
            Model model = new Model();
            model.setName(str);
            model.setKol((int) row.getCell(1).getNumericCellValue());
            model.setLgota(lgota);
            product.add(model);
            num++;
        }
        return product;
    }

    public static ArrayList<Model> sumCollect(ArrayList<Model> prItog, ArrayList<Model> pr) {
        for (int i = 0; i < pr.size(); i++) {
            if (prItog.contains(pr.get(i))) {
                for (int j = 0; j < prItog.size(); j++) {
                    if (pr.get(i).equals(prItog.get(j))) {
                        int a = prItog.get(j).getKol() + pr.get(i).getKol();
                        prItog.get(j).setKol(a);
                    }
                }
            } else prItog.add(pr.get(i));
        }
        return prItog;
    }

    public static void saveExel(ArrayList<Model> data) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NN");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Количество");
        row.createCell(2).setCellValue("Вид льготы");
        rowNum = 1;
        for (Model model : data) {
            Row row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(model.getName());
            row1.createCell(1).setCellValue(model.getKol());
            row1.createCell(2).setCellValue(model.getLgota());
            rowNum++;
        }
        File file1 = new File(
                //TODO: куда сохранять файл отчета
                "C:\\Анализ продаж\\итог.xls");
        try (FileOutputStream out = new FileOutputStream
                (file1)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан! " + file1.toString());
    }

}
