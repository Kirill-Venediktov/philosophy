package chapter12;

class MyException extends RuntimeException{
    private String exceptionText;
    public MyException() {
    }

    public MyException(String message) {
        super(message);
        exceptionText = message;
    }

    public void getExceptionText(){
        System.out.println(exceptionText);
    }
}

public class Task4 {
    public static void f() throws MyException {
        System.out.println("Возбуждаем исключение в f()");
        throw new MyException("Возюбуждено в f()");
    }

    public static void main(String[] args) {
        f();
//        try {
//            f();
//        }catch (MyException e){
//            e.getExceptionText();
//            e.printStackTrace();
//        }
    }
}

class Task8{
    public static void main(String[] args)  {
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
