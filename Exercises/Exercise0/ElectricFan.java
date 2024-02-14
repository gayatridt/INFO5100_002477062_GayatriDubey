public class ElectricFan {
    //region properties
    private String fanType;
    private boolean hasMultipleSpeeds;
    private boolean hasRemoteControl;
    private byte numberOfBlades;
    private boolean hasTimerFunction;
    private boolean isTurnedOn;
    private byte speedLevel;
    private String energyEfficiency;
    private String electricFanId;
    //endregion

    //region constructor
    public ElectricFan(String objName) {
        assignValues();
        this.electricFanId = "ElectricFan_" + objName;
        System.out.println("Electric Fan instance created: " + this.electricFanId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.fanType ="tower fan";
        this.hasMultipleSpeeds = true;
        this.hasRemoteControl = true;
        this.numberOfBlades = 10;
        this.hasTimerFunction = false;
        this.energyEfficiency = "0.0565 kWh";
        this.isTurnedOn = false;
    }

    public void turnOn() {
        this.isTurnedOn = true;
        System.out.println("Turned on " + this.electricFanId+ " Electric Fan");
    }

    public void turnOff() {
        this.isTurnedOn = false;
        System.out.println("Turned off " + this.electricFanId + " Electric Fan");
    }

    public void adjustSpeed(byte level) {
        this.speedLevel = level;
        System.out.println("Adjusted speed to level " + level + " on " + this.electricFanId + " Electric Fan");
    }
    //endregion
}
