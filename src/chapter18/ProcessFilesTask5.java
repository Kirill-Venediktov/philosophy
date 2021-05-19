package chapter18;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProcessFilesTask5 {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String regex;

    public ProcessFilesTask5(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }
    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        Pattern pattern = Pattern.compile(regex);
                        if (pattern.matcher(arg).matches())
                            strategy.process(
                                    new File(arg).getCanonicalFile()
                            );
                    }
                }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        new ProcessFilesTask5(new ProcessFilesTask5.Strategy(){

            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*.txt").start(args);
    }
}
