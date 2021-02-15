package chapter11;

import java.util.PriorityQueue;
import java.util.Random;

public class Task28 {
    public static void main(String[] args) {
        PriorityQueue<Double> doubles = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++){
            doubles.offer(random.nextDouble());
        }
        while (!doubles.isEmpty()){
            System.out.println(doubles.poll());
        }
    }
}
