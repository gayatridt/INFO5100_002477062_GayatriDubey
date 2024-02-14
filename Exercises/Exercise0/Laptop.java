public class Laptop {
    //region properties
    private byte batteryLife;
    private String operatingSystem;
    private byte ram;
    private String storageType;
    private double displaySize;
    private  String resolution;
    private byte numberofPorts;
    private boolean hasTouchId;
    private String laptopId;
    //endregion

    //region constructor
    public Laptop(String objName) {
        assignValues();
        this.laptopId = "Laptop_" + objName;
        System.out.println("Laptop instance created: " + this.laptopId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.batteryLife = 18;
        this.operatingSystem = "macOS";
        this.ram = 8;
        this.storageType = "SSD";
        this.displaySize = 13.3;
        this.resolution = "2560 x 1600";
        this.numberofPorts = 2;
        this.hasTouchId = true;
    }

    public void openApplication() {
        System.out.println("Opening application on " + this.laptopId);
    }

    public void closeApplication() {
        System.out.println("Closing application on " + this.laptopId);
    }

    public void displayBatteryStatus() {
        System.out.println("Battery life for " + this.laptopId + ": " + this.batteryLife);
    }
    //endregion
}