package chapter18;

import java.io.File;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Task6Training {
    public static void main(String[] args) {
        File file = new File(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter18\\forTesting\\Test1.txt");
        long mod = file.lastModified();
        System.out.println(file.lastModified());
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochMilli(mod));
        File file1 = new File("C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter2\\DataOnly.java");
        System.out.println(Instant.ofEpochMilli(file1.lastModified()));
        Date date1 = new Date();
        date1.setTime(file.lastModified());
        System.out.println(date1);
        Date date2 = new Date(file1.lastModified());
        System.out.println(date2);
        System.out.println(date1.before(date2));
        Date date3 = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.set(2021,Calendar.APRIL,30);
        System.out.println(calendar.getWeekYear());
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTimeInMillis(file1.lastModified());
        System.out.println(calendar1.getTime());
        System.out.println(calendar.before(calendar1));

    }
}
