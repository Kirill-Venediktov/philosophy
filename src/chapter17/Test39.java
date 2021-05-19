package chapter17;

public class Test39 {
    public static void main(String[] args) {
        int size = 1997;
        int newSize = size*2;
        for (int i = 2; i < newSize; i++){
            if (newSize % i == 0){
                newSize++;
                i = 1;
            }
        }
        System.out.println(newSize);
    }
}
