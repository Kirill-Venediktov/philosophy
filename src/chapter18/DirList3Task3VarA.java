package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3Task3VarA {
    public static void main(String[] args) {
        File path = new File(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\."
        );
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long overallSize = 0;
        for (String dirItem : list) {
            System.out.println(dirItem);
            File currentPath = new File(path + "\\" + dirItem);
            System.out.println("length = " + currentPath.length());
            overallSize += currentPath.length();
        }
        System.out.println("Общий размер файлов: " + overallSize);

    }
}
