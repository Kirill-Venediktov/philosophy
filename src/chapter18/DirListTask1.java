package chapter18;

import util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirListTask1 {
    public static void main(String[] args) {
        File path = new File("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\.");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilterTask1(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilterTask1 implements FilenameFilter {
    private Pattern pattern;
    public DirFilterTask1(String regex) {
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File file, String name) {
        if (file.isDirectory()){
            String text = TextFile.read(file.getAbsolutePath() + "\\" + name);
            return pattern.matcher(text).find();
        }
        return false;
    }
}
