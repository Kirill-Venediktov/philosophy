package chapter12;

import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean isException = true;
        while (isException){
            try {
                int a = random.nextInt(2);
                int i = 5/a;
                isException = false;
            }catch (Exception e){
                System.err.println("Выявлено исключение");
                e.printStackTrace();
            }
        }

    }
}
