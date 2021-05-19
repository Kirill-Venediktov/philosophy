package chapter10.greenhouseController.controllerFactory;

import chapter10.greenhouseController.Event;
import chapter10.greenhouseController.GreenhouseControls;

public interface Factory<Event> {
    chapter10.greenhouseController.Event create(GreenhouseControls gc, Long time);

}
