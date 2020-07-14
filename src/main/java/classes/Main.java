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

import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
@Configuration
public class Main {
    public static HashMap<String, Vehicle> vehicle_registry =  new HashMap<>();

    public static void main(String[] args) {
        //Load title
        new asciiIntro();


        SpringApplication.run(Main.class, args);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Closing");
    }

    @RestController
    public static class WebService extends SpringBootServletInitializer{

        public WebService() {

        }
        @GetMapping("/start")
        @ResponseBody
        public String createRecords(@RequestParam String add) {
            int count = Integer.parseInt(add);
            new VehicleGenerator().generateMultipleVehicles(count);
            System.out.println("We have " + vehicle_registry.size() + " records");
            return "You requested to create " + count + " records. We now have " + vehicle_registry.size();
        }

        @GetMapping("/scan")
        public String scanRecords() {
            illegalVRMScan response = new illegalVRMScan();
            return response.illegalVRMScan();
        }
    }
}