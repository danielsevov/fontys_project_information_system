package assembler;

import bootstrap.Bootstrapper;
import fontys.frontend.GUIFlightApp;


/**
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
public class Main {

    public static void main(String[] args) {
        new GUIFlightApp(Bootstrapper.initialise()).show();
    }

}
