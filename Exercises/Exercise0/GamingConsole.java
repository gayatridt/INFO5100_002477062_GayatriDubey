public class GamingConsole {
    //region properties
    private boolean isPortable;
    private short storageCapacity;
    private boolean isPoweredOn;
    private String resolutionSupport;
    private String processor;
    private boolean isVirtualRealitySupported;
    private String networkConnectivity;
    private boolean isSocialIntegrated;
    private String consoleId;
    //endregion

    //region constructor
    public GamingConsole(String objName) {
        assignValues();
        this.consoleId = "GamingConsole_" + objName;
        System.out.println("Gaming Console instance created: " + this.consoleId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.isPortable = false;
        this.storageCapacity = 128;
        this.isPoweredOn = false;
        this.resolutionSupport = "4K";
        this.processor = "64bit";
        this.isVirtualRealitySupported = true;
        this.networkConnectivity = "WiFi";
        this.isSocialIntegrated = true;
    }

    public void powerOn() {
        this.isPoweredOn = true;
        System.out.println("Powering on " + this.consoleId);
    }

    public void powerOff() {
        this.isPoweredOn = false;
        System.out.println("Powering off " + this.consoleId);
    }

    public void playGame(String gameTitle) {
        System.out.println("Playing " + gameTitle + " on " + this.consoleId);
    }

    public void installGame(String gameTitle) {
        System.out.println("Installing " + gameTitle + " on " + this.consoleId);
    }

    public void displayStorageInfo() {
        System.out.println("Storage capacity for " + this.consoleId + ": " + this.storageCapacity + "GB");
    }

    public void connectToOnlineService() {
        System.out.println("Connecting " + this.consoleId + " to online gaming service");
    }
    //endregion
}