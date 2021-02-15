package chapter10;

import java.util.Random;

interface Task10_interface{
    void f();
}

public class Task10 {
    Random random = new Random();
    public Task10_interface g(){
        if (random.nextInt(2) == 1){
            class Task10_2 implements Task10_interface{
                @Override
                public void f() {
                    System.out.println("Implemented method");
                }
            }
            return new Task10_2();
        }
        else {
            class Task10_3 implements Task10_interface{
                @Override
                public void f() {
                    System.out.println("another implemented method");
                }
            }
            return new Task10_3();
        }
    }
}
