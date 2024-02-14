public class Main {
    public static void main(String[] args) {
        //Calling class VoiceAssistant and its nested classes
        VoiceAssistant assistant1 = new VoiceAssistant("objVoiceAssistant1");
        VoiceAssistant assistant2 = new VoiceAssistant("objVoiceAssistant2");
        VoiceAssistant assistant3 = new VoiceAssistant("objVoiceAssistant3");
        assistant1.activate();
        assistant2.performTask("Play Song");
        VoiceAssistant.AssistantSettings settings = assistant3.new AssistantSettings();
        VoiceAssistant.AssistantTasks tasks = assistant3.new AssistantTasks();
        settings.displaySettings();
        tasks.addTask("Do something");
        tasks.completeTask();

        //Calling class Camera
        Camera camera1 = new Camera("objCamera1");
        camera1.capturePhoto();
        Camera camera2 = new Camera("objCamera2");
        camera2.recordVideo();
        Camera camera3 = new Camera("objCamera3");
        camera3.adjustSettings("zoom in");

        //Calling class Coffee Maker
        CoffeeMaker coffeeMaker1 = new CoffeeMaker("objCoffeeMaker1");
        coffeeMaker1.startBrewing();
        CoffeeMaker coffeeMaker2 = new CoffeeMaker("objCoffeeMaker2");
        coffeeMaker2.displayWaterLevel();
        CoffeeMaker coffeeMaker3 = new CoffeeMaker("objCoffeeMaker3");
        coffeeMaker3.stopBrewing();

        //Calling class DeskLamp
        DeskLamp lamp1 = new DeskLamp("objDeskLamp1");
        lamp1.turnOn();
        DeskLamp lamp2 = new DeskLamp("objDeskLamp2");
        lamp2.adjustBrightness((byte)2);
        DeskLamp lamp3 = new DeskLamp("objDeskLamp3");
        lamp3.turnOff();

        //Calling class ElectricFan
        ElectricFan fan1 = new ElectricFan("objElectricFan1");
        fan1.turnOn();
        ElectricFan fan2 = new ElectricFan("objElectricFan2");
        fan2.adjustSpeed((byte)3);
        ElectricFan fan3 = new ElectricFan("objElectricFan3");
        fan3.turnOff();

        //Calling class GamingConsole
        GamingConsole console1 = new GamingConsole("objGamingConsole1");
        console1.powerOn();
        GamingConsole console2 = new GamingConsole("objGamingConsole2");
        console2.playGame("Tetris");
        GamingConsole console3 = new GamingConsole("objGamingConsole3");
        console3.displayStorageInfo();

        //Calling class Headphones
        Headphones headphones1 = new Headphones("objHeadphones1");
        headphones1.turnOn();
        Headphones headphones2 = new Headphones("objHeadphones2");
        headphones2.adjustVolume((byte) 2);
        Headphones headphones3 = new Headphones("objHeadphones3");
        headphones3.turnOff();

        //Calling class Laptop
        Laptop laptop1 = new Laptop("objLaptop1");
        laptop1.openApplication();
        Laptop laptop2 = new Laptop("objLaptop2");
        laptop2.displayBatteryStatus();
        Laptop laptop3 = new Laptop("objLaptop3");
        laptop3.closeApplication();

        //Calling class SmartWatch
        SmartWatch watch1 = new SmartWatch("objSmartWatch1");
        watch1.startActivity();
        SmartWatch watch2 = new SmartWatch("objSmartWatch2");
        watch2.displayHealthTracker();
        SmartWatch watch3 = new SmartWatch("objSmartWatch3");
        watch3.endActivity();

        //Calling class Tv
        Tv tv1 = new Tv("objTv1");
        tv1.changeChannel(100);
        Tv tv2 = new Tv("objTv2");
        tv1.connectToInternet();
        Tv tv3 = new Tv("objTv3");
        tv3.displaySettings();
    }
}