package kolichestvoProdag;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static kolichestvoProdag.Exel.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Model> mod = new ArrayList<>();
        //TODO: Папка с расположением анализируемых файлов
        String path = "C:\\Анализ продаж\\Движение 1квартал 2023";
        List<Path> collect = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
        int count = 0;
        for (Path path1 : collect) {
            count++;
            System.out.println("Обрабатывается файл № "+ count + " по адресу " +path1.toString() );
            sumCollect(mod, reedExel(path1.toFile()));
        }
        saveExel(mod);
    }

}
