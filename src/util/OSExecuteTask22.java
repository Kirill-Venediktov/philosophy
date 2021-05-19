package util;

import chapter7.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OSExecuteTask22 {
    public static ArrayList<String> command(String command) {
        ArrayList<String> errArr = new ArrayList<>();
        ArrayList<String> text = new ArrayList<>();
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine())!=null){
                text.add(s);
//                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine())!= null){
                errArr.add(s);
//                System.err.println(s);
                err = true;
            }
            if (!errArr.isEmpty())
                System.out.println(errArr);
        }catch (Exception e) {
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing " + command);
        return text;
    }
}
