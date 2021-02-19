package chapter15;

import util.Generator;

public class Fibbonacci implements Generator<Integer> {
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public Integer next() {
        return fib(count++);
    }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibbonacci gen = new Fibbonacci();
        for (int i = 0; i < 18 ; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}
