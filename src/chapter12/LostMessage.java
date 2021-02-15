package chapter12;

class VeryImportantException extends Exception{
    @Override
    public String toString() {
        return "Очень важное исключение!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "Второстепенное исключение";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            }

            finally {
                try {
                    lm.dispose();
                } catch (HoHumException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
