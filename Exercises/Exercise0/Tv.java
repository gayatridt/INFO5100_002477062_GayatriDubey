public class Tv {
    //region properties
    private byte screenSize;
    private boolean isSmart;
    private String displayType;
    private String resolution;
    private byte volumeLevel;
    private boolean isPoweredOn;
    private String connectivityOption;
    private boolean isVoiceControlEnabled;
    private String tvId;
    //endregion

    //region constructor
    public Tv(String objName) {
        assignValues();
        this.tvId = "Tv_" + objName;
        System.out.println("TV instance created: " + this.tvId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.screenSize = 60;
        this.isSmart = true;
        this.displayType = "LED";
        this.resolution = "FullHD";
        this.volumeLevel = 15;
        this.isPoweredOn = false;
        this.connectivityOption = "WiFi";
        this.isVoiceControlEnabled = true;
    }

    public void powerOn() {
        this.isPoweredOn = true;
        System.out.println("Powering on " + this.tvId);
    }

    public void powerOff() {
        this.isPoweredOn = false;
        System.out.println("Powering off " + this.tvId);
    }

    public void changeChannel(int channelNumber) {
        System.out.println("Changing channel to " + channelNumber + " on " + this.tvId);
    }

    public void streamContent(String content) {
        System.out.println("Streaming " + content + " on " + this.tvId);
    }

    public void displaySettings() {
        System.out.println("Displaying settings for " + this.tvId);
    }

    public void connectToInternet() {
        System.out.println("Connecting " + this.tvId + " to the internet");
    }
    //endregion
}
