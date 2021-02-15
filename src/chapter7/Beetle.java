package chapter7;

class Insect{
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("i = " + i + ", j = " + j);
        j=39;
    }
    private static int x1 = printInit("Поле static Insect.x1 проинициализировано");

    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Поле static Beetle.k проинициализировано");
    public Beetle(){
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("Поле static Beetle.x2 проинициализировано");

    public static void main(String[] args) {
        System.out.println("Конструктор beetle");
        Beetle b = new Beetle();
    }

}

class Bug extends Beetle {
    private int z = printInit("Поле static Bug.z проинициализировано");
    public Bug(){
        System.out.println("z = " + z);
        System.out.println("j = " + j);
    }
    private static int x3 = printInit("Поле static Bug.x3 проинициализировано");

    public static void main(String[] args) {
        System.out.println("Конструктор beetle");
        Beetle b = new Beetle();
        System.out.println("Контструктор Bug");
        Bug bug = new Bug();
    }
}