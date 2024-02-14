public class Headphones {
    //region properties
    private boolean isWireless;
    private boolean isNoiseCancelling;
    private byte batteryLevel;
    private String headphoneType;
    private boolean isPortable;
    private boolean doesSurroundSound;
    private byte volumeLevel;
    private String compatibility;
    private String headphonesId;
    //endregion

    //region constructor
    public Headphones(String objName) {
        assignValues();
        this.headphonesId = "Headphones_" + objName;
        System.out.println("Headphones instance created: " + this.headphonesId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.isWireless = true;
        this.isNoiseCancelling = false;
        this.batteryLevel = 8;
        this.headphoneType = "Earbuds";
        this.isPortable = true;
        this.doesSurroundSound = false;
        this.compatibility = "Apple";
        this.volumeLevel = 0;
    }

    public void turnOn() {
        System.out.println("Turning on " + this.headphonesId + " headphones");
    }

    public void turnOff() {
        System.out.println("Turning off " + this.headphonesId + " headphones");
    }

    public void adjustVolume(byte level) {
        this.volumeLevel = level;
        System.out.println("Adjusting volume to level " + this.volumeLevel + " on " + this.headphonesId + " headphones");
    }
    //endregion
}
