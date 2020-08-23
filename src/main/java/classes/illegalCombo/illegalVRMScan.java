package classes.illegalCombo;

import classes.Main;
import classes.generator.VRMGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class illegalVRMScan {
    List<String> lines;
    ArrayList<String> offendingRegistrations = new ArrayList<String>();

    public String illegalVRMScan() {

        try {
            lines = Files.readAllLines(new File("src/main/resources/illegal_vrm_list.txt").toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to load illegal VRM List";
        }
        System.out.println("Comparing " + lines.size() + " illegal formats against " + Main.vehicleRegistry.size() + " vehicle records");
        AtomicInteger counter = new AtomicInteger();
        for (String line : lines) {
            Pattern pattern = Pattern.compile(line);
            Main.vehicleRegistry.forEach((key, value) -> {
                Matcher m = pattern.matcher(key);
                if (m.find()) {
                    System.out.println("Caught: " + key + " comparing: " + m.pattern());
                    offendingRegistrations.add(key);
                    counter.addAndGet(1);
                }
            });
        }
        for(int i = 0; i < offendingRegistrations.size(); i++){
            replaceVRM(offendingRegistrations.get(i));
            Main.vehicleRegistry.remove(offendingRegistrations.get(i));

        }
        return "Removed " + offendingRegistrations.size() + " illegal registrations";
    }

    private void replaceVRM(String key) {
        try {
            VRMGenerator newVRM = new VRMGenerator();
            String chosen_vrm = newVRM.generate(Main.vehicleRegistry.get(key).getManufactureDate());
            Main.vehicleRegistry.put(chosen_vrm, Main.vehicleRegistry.get(key));
            System.out.println("Replacing: " + key + " with: " + chosen_vrm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

