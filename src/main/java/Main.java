import java.util.HashMap;

public class Main {
    static HashMap<String, Vehicle> vehicle_registry =  new HashMap<>();

    public static void main(String[] args) {
        //Load our title
        asciiIntro intro = new asciiIntro();

        //Start generating vehicles
        Vehicle_Generator fire_them_up = new Vehicle_Generator();
        fire_them_up.generateMultipleVehicles();

        //Scan & replace offensive registrations
        System.out.println("Scanning for illegal registration marks");
        blocked_vrm_search search = new blocked_vrm_search();

        //Scan again with new vrm replacing offensive
        System.out.println("Trying again");
        blocked_vrm_search search2 = new blocked_vrm_search();


    }
}