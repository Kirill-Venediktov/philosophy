package chapter17;

import java.util.PriorityQueue;
import java.util.Random;

class Task11Test implements Comparable<Task11Test> {
    private Random r = new Random();
    private final Integer ID = r.nextInt(100);
    @Override
    public int compareTo(Task11Test task11Test) {
        if (ID > task11Test.ID)
            return 1;
        if (ID == task11Test.ID) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Task11Test{" +
                "ID=" + ID +
                '}';
    }
}

public class Task11 {
    public static void main(String[] args) {
        PriorityQueue<Task11Test> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(new Task11Test());
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
