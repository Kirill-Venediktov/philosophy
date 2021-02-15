package chapter5;

public class Task17 {
    Task17(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        Task17 aa = new Task17("rrrr");
        Task17 bb = new Task17("eeee");
        Task17 cc = new Task17("qqq");
        Task17[] tasks = new Task17[]{
                aa,bb,cc
        };
    }
}
