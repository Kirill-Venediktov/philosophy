package chapter12;

import chapter10.Task7;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Task6_1 extends Exception{
    private static Logger logger = Logger.getLogger("Task6Exception");

    public Task6_1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class Task6 extends  Exception{
    private static Logger logger = Logger.getLogger("Task6Exception");

    public Task6() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new Task6();
        }catch (Exception e){
        }
        try {
            throw new Task6_1();
        }catch (Exception e){
        }
    }
}
