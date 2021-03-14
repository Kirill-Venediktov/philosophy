package chapter15;

interface Task25InterfaceOne {

}

interface Task25InterfaceTwo {

}

class TestClass implements Task25InterfaceOne, Task25InterfaceTwo {

}

public class Task25 {
    public static  <Interface extends Task25InterfaceOne> void methodOne(Interface i){
        System.out.println("Первый метод");
    }
    public static  <Interface extends Task25InterfaceTwo> void methodTwo(Interface i) {
        System.out.println("Второй метод");
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        methodOne(testClass);
        methodTwo(testClass);
    }

}
