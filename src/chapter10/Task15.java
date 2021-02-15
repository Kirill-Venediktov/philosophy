package chapter10;

public class Task15 {
    int i;
    public Task15(int i) {
        this.i = i;
        System.out.println("я родился");
    }
}

class Task15_1 {
    public Task15 f(int i){
        return new  Task15(i){

        };
    }
}