package chapter10;

import chapter10.chapter10_1.Task6;

public class Task6_2 {
    private class Inner implements Task6 {
        public Inner() {
            System.out.println("Hello, im Inner");
        }
    }

    public Task6 getInner(){
        return this.new Inner();
    }
}
