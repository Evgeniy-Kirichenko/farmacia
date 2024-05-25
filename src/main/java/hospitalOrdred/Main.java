package hospitalOrdred;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static hospitalOrdred.Exel.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileRead = "C:\\Катя для анализа\\Парус апрель 2024 ССЗ.xlsx";// какой файл читаем
        String file ="C:\\Катя для анализа\\Парус апрель 2024 ССЗ итог.xls"; // куда сохраняем
        ArrayList<Model> aa = new ArrayList<>();
        ArrayList<Model> bb = new ArrayList<>();
        aa = readFileExel(new File(fileRead));
        bb = summaZakupkiPoNaimenovaniy(aa);
        saveExel(bb, file);

    }
}






