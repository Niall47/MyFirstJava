package classes.controller;

import classes.Main;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;
import classes.model.Vehicle;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public String count(){
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(){
        Main.vehicle_registry.clear();
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }

    @RequestMapping(value = "scan", method = RequestMethod.GET)
    public String scan(){
        new illegalVRMScan();
        return "Scanning for naughty words";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(){
        VehicleGenerator fire_them_up = new VehicleGenerator();
        fire_them_up.generateMultipleVehicles();
        return "Creating 10,000 vehicles";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public HashMap listAll(){
        return Main.vehicle_registry;
    }

    @RequestMapping(value = "rude", method = RequestMethod.GET)
    public HashMap rude(){
        illegalVRMScan name = new illegalVRMScan();
        return name.getNaughtyList();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public ArrayList list(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= Main.vehicle_registry.size(); i++) {
            Main.vehicle_registry.forEach((key, value) -> {
                list.add(key);
            });
        }
        return list;
    }
}
