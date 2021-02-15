package chapter4;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
//            int count = 0;
            for (int j = 1; j < 100; j++) {
                if (i % j == 0 && i != j && j != 1) {
                    System.out.println("Число " + i + " Непростое");
                    break;
                }
                if (j == 99) {
                    System.out.println("Число" + i + " Простое как два рубля");
                }
            }
        }
    }
}
