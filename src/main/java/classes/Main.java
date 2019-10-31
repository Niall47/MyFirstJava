package classes;

import classes.model.Vehicle;
import classes.fileHandler.asciiIntro;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;

import java.util.HashMap;

public class Main {
    public static HashMap<String, Vehicle> vehicle_registry =  new HashMap<>();

    public static void main(String[] args) {

        //Load title
        new asciiIntro();

        //Start generating vehicles
        new VehicleGenerator().generateMultipleVehicles(10000);

        //Scan & replace offensive registrations
        System.out.println("Scanning for illegal registration marks");
        new illegalVRMScan();

        //Print the total number of vehicles registered
        System.out.println("We have " + vehicle_registry.size() + " records");

    }
}