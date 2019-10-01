import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Vehicle_Generator {
    private void vehicleSpecGenerator(JSONArray vehicleList, int numberOfVehicles) {
        System.out.println("Generating vehicles");

        //Make JSON readable and generate a list of possible manufactures
        JSONObject makes = (JSONObject) vehicleList.get(0);
        ArrayList<String> make = new ArrayList<>();
        Object[] manufacturers = makes.keySet().toArray();
        for (Object manufacturer : manufacturers) {
            make.add(manufacturer.toString());
        }

        //Pick a manufacturer
        int randomManufacturer = getRandomInt(0, manufacturers.length - 1);
        String chosenManufacturer = make.get(randomManufacturer);

        //Pick a model associated with our manufacture
        JSONObject vehicleListOne = (JSONObject) vehicleList.get(0);
        ArrayList models = (ArrayList) vehicleListOne.get(chosenManufacturer);
        int randomModel = getRandomInt(0, models.size() - 1);
        String chosenModel = models.get(randomModel).toString();

        //Pick a manufacture date
        int chosenManufactureDate = getRandomInt(1950, 2020);

        //Pick a colour
        String[] colours = {"Red", "Blue", "Silver", "Grey", "Black", "Green", "Yellow"};
        int colourPicker = getRandomInt(0, colours.length - 1);
        String chosenColour = colours[colourPicker];

        //Pick a VRM associated with our manufacture date
        VRM_Generator newVRM = new VRM_Generator();
        String chosenVRM = newVRM.Base_generator(chosenManufactureDate);

        Vehicle vehicle = new Vehicle(chosenManufacturer, chosenModel, chosenColour, chosenManufactureDate);
        Main.vehicle_registry.put(chosenVRM, vehicle);
    }

    void generateMultipleVehicles() {

        //Load list of makes and models
        JSONArray vehicleList;
        JsonRead jsonRead = new JsonRead();
        vehicleList = jsonRead.JsonReader("vehicles.json");

        //find out how many vehicles user wants to register
        System.out.println("How many vehicles are you trying to register? ");
        Scanner userInput = new Scanner(System.in);
        int howManyVehicles = userInput.nextInt();

        for (int count = 0; count <= howManyVehicles; count++) {
            vehicleSpecGenerator(vehicleList, howManyVehicles);
        }

        //report back after generating records
        System.out.println("We now have " + Main.vehicle_registry.size() + " records");
        System.out.println("Caught " + new VRM_Generator().getDuplicateVRM() + " duplicates");
        System.out.println("Caught " + new VRM_Generator().getInvalidCharacters() + " invalid registrations ");

    }

    private int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}