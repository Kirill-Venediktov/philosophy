package chapter10.greenhouseController.controllerFactory;

import chapter10.greenhouseController.Event;
import chapter10.greenhouseController.GreenhouseControls;

public class ThermostatNightFactory implements Factory<Event>{
    @Override
    public Event create(GreenhouseControls gc, Long time) {
        return gc.new ThermostatNight(time);
    }
}
