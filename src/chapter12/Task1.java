package chapter12;

public class Task1 {
    public static void main(String[] args) {
        try {
            throw new Exception("Im Exception");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Блок finally");
        }
    }
}
