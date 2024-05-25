package newPaket;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    Есть четыре файла xlxs, в котрых содержаться данные для анализа. Все файлы имеют одинаковую структуру.
    Товар описан в классе Product
    List<Product> readExel() читает  файл xlxs и преобразует его построчно в коллекцию List<Product>
    количество содержится в поле Kol
    List<Product> pr1 коллекция с прочитанным файлом
    метод listDelPovtor принимает прочитанную коллекцию и возвращает коллекцию без повторов, суммируя количество в повторах
    количество содержаться в плолк Kol

     */
    public static void main(String[] args) throws IOException {

        String file0 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 27.04.2024 ФЗ.xlsx";
        String file1 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 08.05.2024 ФЗ.xlsx";
        String file2 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 17.05.2024 ФЗ.xlsx";
        String file3 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 24.05.2024 ФЗ.xlsx";
        //строки для строки заголовка в итоговый файл .xlx берем дату
        String[] str = new String[]{file0.split(" ")[6],
                file1.split(" ")[6],
                file2.split(" ")[6],
                file3.split(" ")[6]};

        Exel exel0 = new Exel(new File(file0));
        Exel exel1 = new Exel(new File(file1));
        Exel exel2 = new Exel(new File(file2));
        Exel exel3 = new Exel(new File(file3));
        //читаем файлы
        ArrayList<Product> pr0 = exel0.readExel();
        ArrayList<Product> pr1 = exel1.readExel();
        ArrayList<Product> pr2 = exel2.readExel();
        ArrayList<Product> pr3 = exel3.readExel();
        //суммируем повторы в файлах
        ArrayList<Product> prDelPovtor0 = exel0.listDelPovtor(pr0);
        ArrayList<Product> prDelPovtor1 = exel1.listDelPovtor(pr1);
        ArrayList<Product> prDelPovtor2 = exel2.listDelPovtor(pr2);
        ArrayList<Product> prDelPovtor3 = exel3.listDelPovtor(pr3);
        // Объединяем файлы. За основу берем первую коллекцию prDelPovtor0. Добавяляем сначала prDelPovtor1(у нее количество лежит в kol0.
        // Мы его сохраняем в kol1 коллекции prDelPovtor0.
        sumCollec(prDelPovtor0, prDelPovtor1, 1);
        sumCollec(prDelPovtor0, prDelPovtor2, 2);
        sumCollec(prDelPovtor0, prDelPovtor3, 3);
        //записывыем файл
        Exel.saveExel(prDelPovtor0, str);

    }

    public static void sumCollec(List<Product> prItog, List<Product> pr, int num) {
        for (int i = 0; i < pr.size(); i++) {
            if (prItog.contains(pr.get(i))) {
                for (int j = 0; j < prItog.size(); j++) {
                    if (pr.get(i).equals(prItog.get(j))) {
                        if (num == 1) prItog.get(j).setKol1(pr.get(i).getKol());
                        else if (num == 2) prItog.get(j).setKol2(pr.get(i).getKol());
                        else if (num == 3) prItog.get(j).setKol3(pr.get(i).getKol());
                    }
                }
            } else {
                //если совпадений Product нет, то переписываем количество в нужную ячейку, выбираемой по  nun
                if (num == 1) {
                    pr.get(i).setKol1(pr.get(i).getKol());
                    pr.get(i).setKol(0);
                } else if (num == 2) {
                    pr.get(i).setKol2(pr.get(i).getKol());
                    pr.get(i).setKol(0);
                } else if (num == 3){
                    pr.get(i).setKol3(pr.get(i).getKol());
                    pr.get(i).setKol(0);
                }
                // добавляем в исходную коллекцию
                prItog.add(pr.get(i));
            }
        }
    }
}
