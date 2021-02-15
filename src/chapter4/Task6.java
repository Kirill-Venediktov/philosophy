package chapter4;

public class Task6 {
    static int test(int testval, int target, int begin, int end){
        if (testval >= begin && testval <= end){
            System.out.println("Число находится в пределах");
        }else {
            System.out.println("Число за пределами");
        }if(testval > target){
            return +1;
        }else if (testval < target){
            return -1;
        }else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(test(10,5,7,8));
        System.out.println(test(5,10,4,8));
        System.out.println(test(5,5,4,8));
    }
}
