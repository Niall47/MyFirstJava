package classes.controller;

import classes.Main;
import classes.structure.Vehicle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class VehicleController {
    @RequestMapping(value = "vehicles", method = RequestMethod.GET)
    //public List<Vehicle> list(){
    public String vehicle(){
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    //public List<Vehicle> list(){
    public String delete(){
        Main.vehicle_registry.clear();
        return "At present there are " + Main.vehicle_registry.size() + " vehicles registered.";
    }
}
