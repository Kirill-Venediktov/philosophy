package chapter12;

public class Task3 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[1];
        try {
            System.out.println(integers[2]);
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException();
        }
    }
}
