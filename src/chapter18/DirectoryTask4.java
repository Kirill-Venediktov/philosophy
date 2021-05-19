package chapter18;

import util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class DirectoryTask4 {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File file, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }
    public static class TreeInfo implements Iterable<File> {
        private long overallSize = 0;
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
            overallSize += other.overallSize;
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }
    public static TreeInfo walk(String start, String regex) {
        TreeInfo treeInfo = recurseDirs(new File(start), regex);
        System.out.println("Общий размер файлов: " + treeInfo.overallSize);
        return treeInfo;
    }
    public static TreeInfo walk(File start, String regex) {
        TreeInfo treeInfo = recurseDirs(start, regex);
        System.out.println("Общий размер файлов: " + treeInfo.overallSize);
        return treeInfo;
    }
    public static TreeInfo walk(File start) {
        TreeInfo treeInfo = recurseDirs(start, ".*");
        System.out.println("Общий размер файлов: " + treeInfo.overallSize);
        return treeInfo;
    }
    public static TreeInfo walk(String start) {
        TreeInfo treeInfo = recurseDirs(new File(start), ".*");
        System.out.println("Общий размер файлов: " + treeInfo.overallSize + " байт");
        return treeInfo;
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else
                if (item.getName().matches(regex)){
                    result.overallSize += item.length();
                    result.files.add(item);
                }

        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println(walk("."));
        else
            for (String arg : args)
                System.out.println(walk(arg));
    }
}
