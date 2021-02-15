package chapter10.chapter10_2;

import chapter10.Task6_2;
import chapter10.chapter10_1.Task6;

public class Task6_3 extends Task6_2 {
    public Task6 f() {
//        this.new Inner();
//        Task6_2 task6 = new Task6_2();
//        task6.new Inner();
        return this.getInner();
    }

    public static void main(String[] args) {
        Task6_3 task = new Task6_3();
        task.getInner();
        task.f();
    }
}
