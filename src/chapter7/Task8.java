package chapter7;

public class Task8 {
    public Task8(int i){
        System.out.println("Базовый класс");
    }
}

class Task8_1 extends Task8 {
    public Task8_1() {
        super(47);
    }
    public Task8_1(int i){
        super(i);
    }
}
