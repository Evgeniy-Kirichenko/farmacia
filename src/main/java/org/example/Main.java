package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.ExelRead.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String file  = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 15.06.2023 ФЗ.xlsx";
        String file1 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 22.06.2023 ФЗ.xlsx";
        String file2 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 29.06.2023 ФЗ.xlsx";
        String file3 = "C:\\анализ срока годности\\ФЗ\\остатки в АУ на 06.07.2023 ФЗ.xlsx";

        String s = file.split(" ")[6];
        String s1 = file1.split(" ")[6];
        String s2 = file2.split(" ")[6];
        String s3 = file3.split(" ")[6];

        ExelRead exelRead = new ExelRead(new File(new File(file).toString()));
        ExelRead exelRead1 = new ExelRead(new File(new File(file1).toString()));
        ExelRead exelRead2 = new ExelRead(new File(new File(file2).toString()));
        ExelRead exelRead3 = new ExelRead(new File(new File(file3).toString()));

        exelRead.readProduct();
        exelRead1.readProduct1();
        exelRead2.readProduct2();
        exelRead3.readProduct3();

        ArrayList<Product> pr0A = new ArrayList<>();
        ArrayList<Product> pr1A = new ArrayList<>();
        ArrayList<Product> pr2A = new ArrayList<>();
        ArrayList<Product> pr3A = new ArrayList<>();

        ArrayList<Product> pr0 = new ArrayList<>(exelRead.productArrayList);
        ArrayList<Product> pr1 = new ArrayList<>(exelRead1.productArrayList);
        ArrayList<Product> pr2 = new ArrayList<>(exelRead2.productArrayList);
        ArrayList<Product> pr3 = new ArrayList<>(exelRead3.productArrayList);

        arLis(pr0A, pr0, 0);
        arLis(pr1A, pr1, 1);
        arLis(pr2A, pr2, 2);
        arLis(pr3A, pr3, 3);

        arLiatToArList(pr0A, pr1A, 1);
        arLiatToArList(pr0A, pr2A, 2);
        arLiatToArList(pr0A, pr3A, 3);

        safe(pr0A, s, s1, s2, s3);
    }

    // добавляем коллекция 1 файла в сборную коллекцию
    static void arLis(ArrayList<Product> prNew, ArrayList<Product> pr, int numKol) {
        for (int i = 0; i < pr.size(); i++) {
            if (prNew.contains(pr.get(i))) {
                for (int j = 0; j < prNew.size(); j++) {
                    if (pr.get(i).equals(prNew.get(j))) {
                        if (numKol == 0) {
                            Integer a = Integer.parseInt(pr.get(i).getQuantity()) + Integer.parseInt(prNew.get(j).getQuantity());
                            prNew.get(j).setQuantity(a.toString());
                        } else if (numKol == 1) {
                            Integer a = Integer.parseInt(pr.get(i).getQuantity1()) + Integer.parseInt(prNew.get(j).getQuantity1());
                            prNew.get(j).setQuantity1(a.toString());
                            // break;
                        } else if (numKol == 2) {
                            Integer a = Integer.parseInt(pr.get(i).getQuantity2()) + Integer.parseInt(prNew.get(j).getQuantity2());
                            prNew.get(j).setQuantity2(a.toString());
                            // break;
                        } else if (numKol == 3) {
                            Integer a = Integer.parseInt(pr.get(i).getQuantity3()) + Integer.parseInt(prNew.get(j).getQuantity3());
                            prNew.get(j).setQuantity3(a.toString());
                            //break;
                        }
                    }
                }
            } else prNew.add(pr.get(i));
        }
    }


    // За коллекция для накопления результата берем коллекцию нулевого файла, вторая коллкция это которую надо добавить в эту коллекция, numKol куда
    // писать количество
    static void arLiatToArList(ArrayList<Product> pr, ArrayList<Product> pr1, int numKol) {
        for (int i = 0; i < pr1.size(); i++) {
            if (pr.contains(pr1.get(i))) {// проверяем наличие такого элемента в коллекции 1 файла. Если есть, то
                for (int j = 0; j < pr.size(); j++) {
                    if (pr1.get(i).equals(pr.get(j))) {// находи этот элемент в коллекции
                        if (numKol == 1) {
                            pr.get(j).setQuantity1(pr1.get(i).getQuantity1()); // и во второе значений количества записываем значение из второго файла
                        } else if (numKol == 2) {
                            pr.get(j).setQuantity2(pr1.get(i).getQuantity2()); // и в третьего значений количества записываем значение из третьего файла
                        } else if (numKol == 3) {
                            pr.get(j).setQuantity3(pr1.get(i).getQuantity3()); // и в четвертое значений количества записываем значение из четвертого файла
                        }
                    }
                }
            } else pr.add(pr1.get(i)); //если нет то добавляем запись в коллекцию 1 файла
        }
    }
}
