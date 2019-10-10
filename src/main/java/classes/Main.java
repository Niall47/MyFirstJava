package classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import classes.model.Vehicle;
import classes.fileHandler.asciiIntro;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;
import java.util.HashMap;

@SpringBootApplication
public class Main {
    public static HashMap<String, Vehicle> vehicle_registry =  new HashMap<>();
    public static void main(String[] args) {
        //Load our title
        asciiIntro intro = new asciiIntro();
        SpringApplication.run(Main.class, args);

        //Start generating vehicles
        VehicleGenerator fire_them_up = new VehicleGenerator();
        fire_them_up.generateMultipleVehicles();

        //Scan & replace offensive registrations
        System.out.println("Scanning for illegal registration marks");
        illegalVRMScan first = new illegalVRMScan();
        System.out.println("Trying again");
        new illegalVRMScan();
//        vehicle_registry.entrySet()
//                .forEach(System.out::println);


    }
}