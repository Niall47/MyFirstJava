import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;


public class JsonWrite {
    public void JsonWriter() {
        System.out.println("Creating JSON file");
        JSONObject vehicle = new JSONObject(); //Make the vehicle
        vehicle.put("Make","Mazda");
        vehicle.put("Model","MX5");
        vehicle.put("Date","1989");
        vehicle.put("Colour","Grey");
        JSONObject vehicleObject = new JSONObject();
        vehicleObject.put("G227 LNY", vehicle); //Assign a VRM

        JSONArray vehicleList = new JSONArray();
        vehicleList.add(vehicleObject);  //Add vehicle to list

        try (
                FileWriter file = new FileWriter("vehicles.json")) {
            file.write(vehicleList.toJSONString()); //Create the file, catch any errors thrown
            file.flush();
        }catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
