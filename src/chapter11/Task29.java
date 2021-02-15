package chapter11;

import java.util.PriorityQueue;

public class Task29 {

}

class Task29_1 {
    public static void main(String[] args) {
        PriorityQueue<Task29> task29s = new PriorityQueue<>();
        for (int i = 0; i < 10; i++){
            task29s.offer(new Task29());
        }
        task29s.offer(new Task29());
        task29s.offer(new Task29());
    }
}
