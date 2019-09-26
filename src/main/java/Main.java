import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap vehicle_registry =  new HashMap();

    public static void main(String[] args) {
        asciiIntro intro = new asciiIntro();
        Vehicle_Generator fire_them_up = new Vehicle_Generator();
        fire_them_up.generateMultipleVehicles();
    }
}
