package chapter12;

public class FailingConstructor {
    Task23 task23_1;
    Task23 task23_2;
    public FailingConstructor(){
        task23_1 = new Task23();
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
        task23_2 = new Task23();
    }

    public void dispose(){
        System.out.println("FailingConstructor dispose()");
    }

    public static void main(String[] args) {
        FailingConstructor failingConstructor = new FailingConstructor();
    }
}

class Task23 {
    public void dispose(){
        System.out.println("dispose()");
    }
}
