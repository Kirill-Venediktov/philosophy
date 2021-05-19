package chapter18;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList {
    private File toRead;
    private String[] files;

    public SortedDirList(String s) {
        this.toRead = new File(s);
        files = toRead.list();
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
    }

    public String[] list() {
        return files;
    }
    public String[] list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> changed = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < files.length; i++) {
            if (pattern.matcher(files[i]).matches()){
                changed.add(files[i]);
                count++;
            }
        }
        return changed.toArray(new String[count]);
    }

    public static void main(String[] args) {
        SortedDirList dirList = new SortedDirList(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\."
        );
        System.out.println(Arrays.toString(dirList.list()));
        System.out.println(Arrays.toString(dirList.list("\\w+\\.\\w+")));
    }
}
