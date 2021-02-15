package chapter12;

class Annoyance extends RuntimeException{
}

class Sneeze extends Annoyance{
}

class WrapCheckedException {
    void throwRuntimeException(int type){
        try {
            switch (type){
                case 0: throw new Annoyance();
                case 1: throw new Sneeze();
                case 2: throw new RuntimeException("Where am I??");
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}

public class Human {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for (int i = 0; i< 4; i++){
            try {
                if (i<3){
                    wce.throwRuntimeException(i);
                }else{
                    throw new MyException9_1();
                }
            } catch (MyException9_1 myException9_1) {
                myException9_1.printStackTrace();
            }
        }
    }
}
