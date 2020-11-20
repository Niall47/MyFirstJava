package classes;

import classes.model.Vehicle;
import classes.fileHandler.asciiIntro;
import classes.generator.VehicleGenerator;
import classes.illegalCombo.illegalVRMScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@SpringBootApplication
@Configuration
public class Main {
    public static HashMap<String, Vehicle> vehicleRegistry =  new HashMap<>();
    public static void main(String[] args) {

        System.out.println(System.getProperty("java.class.path"));
        SpringApplication.run(Main.class, args);
    }
    @Controller
    public class IndexController {

        /**
         * Serve the index page with links to the options
         */
        @GetMapping("/")
        public String index(Model model) {
            model.addAttribute("message", vehicleRegistry.size());
            return "index";

        }
    }

    @RestController
    public static class WebService extends SpringBootServletInitializer{

        public WebService() {
            new asciiIntro();
        }

        /**
         * Generate the number of vehicle records
         */
        @GetMapping("/start")
        @ResponseBody
        public String createRecords(@RequestParam String add) {
            int count;
                try {
                    count = Integer.parseInt(add);
                } catch (NumberFormatException e) {
                    return "Please supply a number";
                }

                new VehicleGenerator().generateMultipleVehicles(count);
                System.out.println("We have " + vehicleRegistry.size() + " records");
                return "You requested to create " + count + " records. We now have " + vehicleRegistry.size();

        }

        /**
         * Scan through all records for offensive combinations and returns a string confirming number changed
         */
        @GetMapping("/scan")
        public String scanRecords() {
            if (vehicleRegistry.isEmpty()){
                return "We dont have any records to scan";
            } else {
                illegalVRMScan response = new illegalVRMScan();
                return response.illegalVRMScan();
            }
        }
    }
}