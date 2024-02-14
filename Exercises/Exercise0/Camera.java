public class Camera {
    //region properties
    private String cameraType;
    private boolean isDigital;
    private String sensorType;
    private short megaPixels;
    private boolean hasAutofocus;
    private boolean hasImageStabilization;
    private String shutterSpeedRange;
    private boolean hasWirelessConnectivity;
    private String cameraId;
    //endregion

    //region constructor
    public Camera(String objName) {
        assignValues();
        this.cameraId = "Camera_" + objName;
        System.out.println("Camera instance created: " + this.cameraId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.cameraType = "DSLR";
        this.isDigital = true;
        this.sensorType = "CMOS";
        this.megaPixels = 15;
        this.hasAutofocus = true;
        this.hasImageStabilization = false;
        this.shutterSpeedRange ="1/8000";
        this.hasWirelessConnectivity = false;
    }

    public void capturePhoto() {
        System.out.println("Capturing photo with " + this.cameraId + " camera");
    }

    public void recordVideo() {
        System.out.println("Recording video with " + this.cameraId + " camera");
    }

    public void adjustSettings(String setting) {
        System.out.println("Adjusting " + setting + " settings on " + this.cameraId + " camera");
    }
    //endregion
}