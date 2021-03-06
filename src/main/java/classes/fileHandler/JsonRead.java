package classes.fileHandler;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JsonRead {
    public JSONArray JsonReader(String filename) {
        System.out.println("Reading JSON file: " + filename);
        JSONParser jsonParser = new JSONParser();
        JSONArray vehicle_List = new JSONArray();
        try (
            FileReader reader = new FileReader(filename))
        {
            Object obj = jsonParser.parse(reader);
            vehicle_List = (JSONArray) obj;
        } catch (
            IOException | ParseException e) {
                e.printStackTrace();
        }
        return vehicle_List;
    }
}


