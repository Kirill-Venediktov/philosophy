package chapter18;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task6 {
    private Calendar calendar;


    public Task6(int year, int month, int day) {
        calendar = new GregorianCalendar(year, month,day);
    }

    public void start(String[] args){
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Calendar fileCal = new GregorianCalendar();
                fileCal.setTimeInMillis(file.lastModified());
                if (fileCal.after(calendar))
                    System.out.println(file);
            }
        }, "java").start(args);
    }

    public static void main(String[] args) {
        Task6 task6 = new Task6(2021, Calendar.APRIL, 15);
        task6.start(args);
    }
}
