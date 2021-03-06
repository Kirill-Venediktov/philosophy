package chapter10.greenhouseController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GreenhouseControllerTask11Chapter18 {
    public static Map<String, Long> readEvents(String eventsLink) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(eventsLink));
        String s;
        Map <String, Long> events = new HashMap<>();
        while ((s = in.readLine())!= null){
            String[] strings = s.split("[()]");
            events.put(strings[0], Long.valueOf(strings[1]));
        }
        in.close();
        return events;
    }
    public static Event makeEvent(Map.Entry<String, Long> entry, GreenhouseControls gc){
        if (entry.getKey().equals("ThermostatNight")) return gc.new ThermostatNight(entry.getValue());
        if (entry.getKey().equals("LightOn")) return gc.new LightOn(entry.getValue());
        if (entry.getKey().equals("LightOff")) return gc.new LightOff(entry.getValue());
        if (entry.getKey().equals("WaterOn")) return gc.new WaterOn(entry.getValue());
        if (entry.getKey().equals("WaterOff")) return gc.new WaterOff(entry.getValue());
        if (entry.getKey().equals("ThermostatDay")) return gc.new ThermostatDay(entry.getValue());
        return null;
    }


    public static void main(String[] args) throws IOException {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Map<String, Long> em = readEvents(
                "C:\\Users\\Кирилл Анатольевич\\Documents\\Programming\\philosophy\\src\\chapter10\\greenhouseController\\1.txt"
        );
        ArrayList<Event> ea = new ArrayList<>();

        for (Map.Entry entry : em.entrySet()){
            ea.add(makeEvent(entry,gc));
        }
        Event[] events = ea.toArray(new Event[ea.size()]);
        gc.addEvent(gc.new Restart(2000, events));
        if (args.length == 1)
            gc.addEvent(
                    new GreenhouseControls.Terminate(new Integer(args[0]))
            );
        gc.run();

    }


}
