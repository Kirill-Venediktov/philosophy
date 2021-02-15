package chapter11;

import java.util.LinkedList;
import java.util.Queue;



public class Command {
    private String string;

    public String operation(){
        string = Task18.getName();
        System.out.println(string);
        return string;
    }
}

class Task25 {
   static public Queue<Command> queueFilling(){
        Queue<Command> commands = new LinkedList<>();
        for (int i = 0; i < 10; i++){
            commands.add(new Command());
        }
        return commands;
    }
}

class Task25_1 {
    static public void showMeWhatYouGot(Queue<Command> commands){
        while (commands.peek() != null){
            commands.remove().operation();
        }
    }

    public static void main(String[] args) {
        showMeWhatYouGot(Task25.queueFilling());
    }
}