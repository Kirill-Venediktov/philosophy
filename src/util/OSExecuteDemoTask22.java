package util;

import java.util.ArrayList;

public class OSExecuteDemoTask22 {
    public static void main(String[] args) {
        ArrayList<String> strings = OSExecuteTask22.command("javap OSExecuteDemoTask22");
        System.out.println(strings);
//        for (String s : OSExecuteTask22.command("javap OSExecuteDemoTask22"))
//            System.out.println(s);
    }
}
