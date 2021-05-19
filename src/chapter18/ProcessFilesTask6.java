package chapter18;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProcessFilesTask6 {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    private Calendar calendar;

    public ProcessFilesTask6(Strategy strategy, String ext, int year, int month, int day) {
        this.strategy = strategy;
        this.ext = ext;
        this.calendar = new GregorianCalendar(year, month, day);
    }
    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    Calendar fileArgCal = new GregorianCalendar();
                    fileArgCal.setTimeInMillis(fileArg.lastModified());
                    if (fileArgCal.after(calendar)){
                        if (fileArg.isDirectory())
                            processDirectoryTree(fileArg);
                        else {
                            if (!arg.endsWith("." + ext))
                                arg += "." + ext;
                            strategy.process(
                                    new File(arg).getCanonicalFile()
                            );
                        }
                    }
                }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        Calendar fileCal = new GregorianCalendar();
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)){
            fileCal.setTimeInMillis(file.lastModified());
            if (fileCal.after(calendar))
                strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFilesTask6(new ProcessFilesTask6.Strategy(){

            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java", 2021, Calendar.MAY,1).start(args);
    }
}
