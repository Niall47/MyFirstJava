package classes.controller;

import classes.Main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{
    @RequestMapping("/")
    public int home(){
        return Main.vehicle_registry.size();

    }
}
