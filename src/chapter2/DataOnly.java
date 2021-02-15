package chapter2;

public class DataOnly {
    int i = 55;
    double d = 5.6;
    boolean b = true;

    DataOnly(){
        System.out.println("Привет, создался объект DataOnly");
    }

    int storage(String s){
        return s.length()*2;
    }

    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly();
        System.out.println(dataOnly.b);
        System.out.println(dataOnly.d);
        System.out.println(dataOnly.i);

        System.out.println("Длина строки умноженная на два: " + dataOnly.storage("Hello"));
    }
}
