package chapter9;

public abstract class Task2 {
    public Task2() {
        print();
    }

    public abstract void print();
}

class Task3 extends Task2{
    private int i = 5;
    @Override
    public void print() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.print();
    }
}