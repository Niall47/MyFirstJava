import com.sun.naming.internal.VersionHelper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class JsonRead {
    JSONArray JsonReader(String filename) {
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


