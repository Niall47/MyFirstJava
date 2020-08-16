package classes.generator;

import classes.Main;
import classes.fileHandler.JsonRead;
import classes.model.Vehicle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class VehicleGenerator {
    private void VehicleSpecGenerator(JSONArray vehicleList, int numberToGenerate){

        JSONObject makes = (JSONObject) vehicleList.get(0);
        ArrayList<String> make = new ArrayList<>();
        Object[] manufacturers = makes.keySet().toArray();
        for (Object manufacturer : manufacturers) {
            make.add(manufacturer.toString());
        }

        String[] colours = {"Red", "Blue", "Silver", "Grey", "Black", "Green", "Yellow"};

        for (int count = 1; count <= numberToGenerate; count++) {

            int manufacturerInt = getRandomInt(0, manufacturers.length-1);
            String manufacturer = make.get(manufacturerInt);

            ArrayList models = (ArrayList) vehicleList.get(manufacturerInt);
            int modelInt = getRandomInt(0, models.size()-1);
            String model = models.get(modelInt).toString();

            String colour = colours[getRandomInt(0, colours.length-1)];

            int manufactureDate = getRandomInt(1950, 2020);

            VRMGenerator newVRM = new VRMGenerator();
            String chosen_vrm = newVRM.Base_generator(manufactureDate );

            if(Main.vehicleRegistry.get(chosen_vrm) != null ){
                count -= 1;
            }

            Main.vehicleRegistry.put(
                    chosen_vrm,
                    new Vehicle(manufacturer, model, colour, manufactureDate
                    ));
        }
    }

    public void generateMultipleVehicles(int howManyVehicles) {

        JsonRead jsonRead = new JsonRead();
        JSONArray vehicle_list = jsonRead.JsonReader("src/main/resources/vehicles.json");
        System.out.println(String.format("Generating %s new vehicles", howManyVehicles));
        VehicleSpecGenerator(vehicle_list, howManyVehicles);

        //Report back
        System.out.println("Caught " + new VRMGenerator().getDuplicateVRM() + " duplicates");
        System.out.println("Caught " + new VRMGenerator().getInvalidCharacters() + " invalid registrations ");
        System.out.println("We have " + Main.vehicleRegistry.size() + " records");

    }

    private int getRandomInt(double min, double max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

}