package chapter11;

public class Task15 {
    public static void main(String[] args) {
        String target = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        Stack<String> stack = new Stack<>();
        String [] strings = target.split("");
        for (int i = 0; i<strings.length; i++){
            if (strings[i].equals("+")){
                stack.push(strings[++i]);
                continue;
            }
            if (strings[i].equals("-")){
                System.out.println(stack.pop());
            }
        }
    }
}
