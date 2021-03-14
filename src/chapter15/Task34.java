package chapter15;

abstract class Task34<T extends Task34<T>> {
     abstract T setAndGet(T t);

     public T methodSetAndGet(T t) {
         return setAndGet(t);
     }
}

class Task34_1 extends Task34<Task34_1> {
   private Task34_1 task34_1;

    @Override
    Task34_1 setAndGet(Task34_1 task34_1) {
        this.task34_1 = task34_1;
        System.out.println("Hello киски");
        return task34_1;
    }
}

class Test {
    public static void main(String[] args) {
        Task34_1 task34_1 = new Task34_1();
        task34_1.setAndGet(task34_1);
        task34_1.methodSetAndGet(task34_1);
    }

}
