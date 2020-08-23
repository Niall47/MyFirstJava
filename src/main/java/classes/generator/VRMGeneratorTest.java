package classes.generator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VRMGeneratorTest {

    @Test
    public void generate1900() {
        String newVRM = new VRMGenerator().generate(1900);
        Assert.assertTrue(newVRM.startsWith("Q"));
    }

    @Test
    public void generate2000() {
        String newVRM = new VRMGenerator().generate(2000);
        Assert.assertTrue(newVRM.startsWith("V"));
    }

    @Test
    public void generateDateless() {
        String newVRM = new VRMGenerator().generate(1903);
        String first = newVRM.substring(0,1);
        Assert.assertTrue(newVRM + " should start with an integer", first.matches("\\d+"));
    }
}