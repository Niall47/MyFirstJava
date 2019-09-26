import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sun.jvm.hotspot.utilities.ObjectReader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

class Vehicle_Generator {
    private void Vehicle_Spec_Generator(JSONArray vehicle_list, int number_of_vehicles){
        System.out.println("Generating " + (number_of_vehicles + 1) + " vehicles");
        for (int count = 0; count <= number_of_vehicles; count++) {
            //Make JSON readable and generate a list of possible manufactures
            JSONObject makes = (JSONObject) vehicle_list.get(0);
            ArrayList<String> make = new ArrayList<>();
            Object[] manufacturers = makes.keySet().toArray();
            for(int i = 0; i < manufacturers.length; i++){
                make.add(manufacturers[i].toString()); }

            //Pick a manufacture
            double random_number = getRandomInt(0, manufacturers.length-1);
            int random_manufacture = (int) random_number;
            String chosen_manufacture = make.get(random_manufacture);

            //Pick a model associated with our manufacture
            JSONObject vehicle_list1 = (JSONObject) vehicle_list.get(0);
            ArrayList models = (ArrayList) vehicle_list1.get(chosen_manufacture);
            double random_number2 = getRandomInt(0, models.size()-1);
            int random_model = (int) random_number2;
            String chosen_model = models.get(random_model).toString();

            //Pick a manufacture date
            double random_number3 = getRandomInt(1950, 2020);
            int chosen_manufacture_date = (int) random_number3;

            //Pick a colour
            String[] colours = {"Red", "Blue", "Silver", "Grey", "Black", "Green", "Yellow"};
            double random_number4 = getRandomInt(0, colours.length-1);
            int colour_picker = (int) random_number4;
            String chosen_colour = colours[colour_picker];

            //Pick a VRM associated with our manufacture date
            VRM_Generator newVRM = new VRM_Generator();
            newVRM.Base_generator(chosen_manufacture_date);
            String chosen_vrm = newVRM.Base_generator(chosen_manufacture_date);
            Vehicle vehicle = new Vehicle(chosen_vrm, chosen_manufacture, chosen_model, chosen_colour, chosen_manufacture_date);
            Main.vehicle_registry.put(chosen_vrm, vehicle);
        }
    }
    void generateMultipleVehicles() {

        //Load list of makes and models
        JSONArray vehicle_list = new JSONArray();
        JsonRead jsonRead = new JsonRead();
        vehicle_list = jsonRead.JsonReader("vehicles.json");

        //find out how many vehicles user wants to register
        System.out.println("How many vehicles are you trying to register? ");
        Scanner user_input = new Scanner(System.in);
        int how_many_vehicles = user_input.nextInt();

        Vehicle_Spec_Generator(vehicle_list, how_many_vehicles -1);
        System.out.println("We have generated " + Main.vehicle_registry.size() + " records");
        System.out.println("Caught " + new VRM_Generator().getDuplicateVRM() + " duplicates");
        System.out.println("Caught " + new VRM_Generator().getInvalidCharacters() + " invalid registrations ");
    }

    private double getRandomInt(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

}