package classes.generator;

import classes.Main;
import classes.model.Vehicle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class VehicleGeneratorTest {
    @After
    public void tearDown() throws Exception {
        Main.vehicleRegistry.clear();
    }

    @Test
    public void generate47Vehicles() {
        new VehicleGenerator().generateMultipleVehicles(47);
        Assert.assertEquals(47, Main.vehicleRegistry.size());
    }

    @Test
    public void generate0Vehicles() {
        new VehicleGenerator().generateMultipleVehicles(0);
        Assert.assertEquals(0, Main.vehicleRegistry.size());
    }

    @Test
    public void generate100000Vehicles() {
        new VehicleGenerator().generateMultipleVehicles(100000);
        Assert.assertEquals(100000, Main.vehicleRegistry.size());
    }

    @Test
    public void generateNegativeVehicles() {
        new VehicleGenerator().generateMultipleVehicles(-100);
        Assert.assertEquals(0, Main.vehicleRegistry.size());
    }
}