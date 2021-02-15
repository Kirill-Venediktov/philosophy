package chapter9;

public interface Task13 {
    void f();
}

interface Task13_1 extends Task13{

}

interface Task13_2 extends Task13{

}

interface Task13_3 extends Task13_1, Task13_2 {

}