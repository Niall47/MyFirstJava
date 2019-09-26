public class Vehicle {
    private String vrm;
    private String make;
    private String model;
    private String colour;
    private int manufactureDate;

    @Override
    public String toString(){
        return "VRM: " + vrm + " - Make: " + make + ", Model: " + model + ", Colour: " + colour + ", Built: " + manufactureDate;
    }

    public String getVrm() {
        return vrm;
    }

    public void setVrm() {
        this.make = vrm;
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(int manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    Vehicle(String vrm, String make, String model, String colour, int manufactureDate){
        this.vrm = vrm;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.manufactureDate = manufactureDate;
    }
}