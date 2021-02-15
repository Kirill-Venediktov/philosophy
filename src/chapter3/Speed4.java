package chapter3;

public class Speed4 {
    void calculate(int distance, int time){
        System.out.println("Скорость равна: " + distance/time);
    }

    public static void main(String[] args) {
        Speed4 speed4 = new Speed4();
        int time = 5;
        int distance = 35;
        speed4.calculate(distance, time);
    }
}
