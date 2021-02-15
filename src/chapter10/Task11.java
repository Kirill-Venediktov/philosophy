package chapter10;

interface Task11Inerface{

}

public class Task11 {
    private class Inner implements Task11Inerface{
        void g(){
            System.out.println("g()");
        }
    }

    public Task11Inerface getInner(){
        Task11Inerface inner = new Inner();
        return inner;
    }

    public static void main(String[] args) {
        Task11 task11 = new Task11();
        Task11Inerface inner = task11.getInner();
//        (Inner)inner.g();
    }
}
