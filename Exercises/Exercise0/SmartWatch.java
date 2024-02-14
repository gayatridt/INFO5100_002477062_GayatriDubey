public class SmartWatch {
    //region properties
    private byte batteryLevel;
    private String strapMaterial;
    private String fitnessTrackingSensors;
    private boolean isWaterResistant;
    private boolean isSimCardCompatible;
    private String watchFaceCustomization;
    private boolean doesSleepTracking;
    private boolean doesFallDetection;
    private boolean hasVoiceControl;
    private String smartWatchId;
    //endregion

    //region constructor
    public SmartWatch(String objName) {
        assignValues();
        this.smartWatchId = "SmartWatch_" + objName;
        System.out.println("SmartWatch instance created: " + this.smartWatchId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.batteryLevel = 50;
        this.strapMaterial = "Rubber";
        this.fitnessTrackingSensors = "heart monitor";
        this.isWaterResistant = true;
        this.isSimCardCompatible = false;
        this.watchFaceCustomization = "custom";
        this.doesSleepTracking = true;
        this.doesFallDetection = true;
        this.hasVoiceControl = true;
    }

    public void startActivity() {
        System.out.println("Starting activity on SmartWatch: " + this.smartWatchId);
    }

    public void endActivity() {
        System.out.println("Ending activity on SmartWatch: " + this.smartWatchId);
    }

    public void displayHealthTracker() {
        System.out.println("Health Tracker for SmartWatch: " + this.smartWatchId);
    }
    //endregion
}