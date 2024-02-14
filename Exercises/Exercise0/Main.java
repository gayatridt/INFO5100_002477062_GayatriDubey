public class Main {
    public static void main(String[] args) {
        //Calling class VoiceAssistant and its nested classes
        VoiceAssistant assistant1 = new VoiceAssistant("objVoiceAssistant1");
        VoiceAssistant assistant2 = new VoiceAssistant("objVoiceAssistant2");
        VoiceAssistant assistant3 = new VoiceAssistant("objVoiceAssistant3");
        VoiceAssistant.AssistantSettings settings = assistant1.new AssistantSettings();
        VoiceAssistant.AssistantTasks tasks = assistant1.new AssistantTasks();
        settings.displaySettings();
        tasks.addTask("Do something");
        tasks.completeTask();

        //Calling class Camera
        Camera camera1 = new Camera("objCamera1");
        Camera camera2 = new Camera("objCamera2");
        Camera camera3 = new Camera("objCamera3");

        //Calling class Coffee Maker
        CoffeeMaker coffeeMaker1 = new CoffeeMaker("objCoffeeMaker1");
        CoffeeMaker coffeeMaker2 = new CoffeeMaker("objCoffeeMaker2");
        CoffeeMaker coffeeMaker3 = new CoffeeMaker("objCoffeeMaker3");

        //Calling class DeskLamp
        DeskLamp lamp1 = new DeskLamp("objDeskLamp1");
        DeskLamp lamp2 = new DeskLamp("objDeskLamp2");
        DeskLamp lamp3 = new DeskLamp("objDeskLamp3");

        //Calling class ElectricFan
        ElectricFan fan1 = new ElectricFan("objElectricFan1");
        ElectricFan fan2 = new ElectricFan("objElectricFan2");
        ElectricFan fan3 = new ElectricFan("objElectricFan3");

        //Calling class GamingConsole
        GamingConsole console1 = new GamingConsole("objGamingConsole1");
        GamingConsole console2 = new GamingConsole("objGamingConsole2");
        GamingConsole console3 = new GamingConsole("objGamingConsole3");

        //Calling class Headphones
        Headphones headphones1 = new Headphones("objHeadphones1");
        Headphones headphones2 = new Headphones("objHeadphones2");
        Headphones headphones3 = new Headphones("objHeadphones3");

        //Calling class Laptop
        Laptop laptop1 = new Laptop("objLaptop1");
        Laptop laptop2 = new Laptop("objLaptop2");
        Laptop laptop3 = new Laptop("objLaptop3");

        //Calling class SmartWatch
        SmartWatch watch1 = new SmartWatch("objSmartWatch1");
        SmartWatch watch2 = new SmartWatch("objSmartWatch2");
        SmartWatch watch3 = new SmartWatch("objSmartWatch3");

        //Calling class Tv
        Tv tv1 = new Tv("objTv1");
        Tv tv2 = new Tv("objTv2");
        Tv tv3 = new Tv("objTv3");
    }
}
