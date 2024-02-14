public class DeskLamp {
    //region properties
    private boolean isAdjustable;
    private boolean hasTouchControls;
    private boolean isTurnedOn;
    private byte brightnessLevel;
    private String lightSource;
    private String colorTemperature;
    private boolean hasUsbPort;
    private boolean supportsWirelessCharging;
    private String deskLampId;
    //endregion

    //region constructor
    public DeskLamp(String objName) {
        assignValues();
        this.deskLampId = "DeskLamp_" + objName;
        System.out.println("Desk Lamp instance created: " + this.deskLampId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.isAdjustable = true;
        this.hasTouchControls = false;
        this.lightSource = "LED";
        this.colorTemperature = "2700K";
        this.hasUsbPort = false;
        this.supportsWirelessCharging = false;
    }

    public void turnOn() {
        this.isTurnedOn = true;
        System.out.println("Turned on " + this.deskLampId + " Desk Lamp");
    }

    public void turnOff() {
        this.isTurnedOn = false;
        System.out.println("Turned off " + this.deskLampId + " Desk Lamp");
    }

    public void adjustBrightness(byte level) {
        this.brightnessLevel = level;
        System.out.println("Adjusted brightness to level " + this.brightnessLevel + " on " + this.deskLampId + " Desk Lamp");
    }
    //endregion
}