package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3Task3VarB {
    public static void main(String[] args) {
        File path = new File(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\"
        );
        long overallSize = 0;
        String[] list;
        File[] files = path.listFiles();
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File file, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list){
            System.out.println(dirItem);
            File currentPath = new File(path + "\\" + dirItem);
            System.out.println("length = " + currentPath.length());
            overallSize += currentPath.length();
        }
        System.out.println("Общий размер файлов: " + overallSize);


        System.out.println("для проверки:");
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
        System.out.println(Arrays.toString(files));


    }
}
