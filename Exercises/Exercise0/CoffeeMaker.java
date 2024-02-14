//region imports
import java.time.Duration;
//endregion
public class CoffeeMaker {
    //region properties
    private boolean isSingleServe;
    private boolean hasTimer;
    private byte waterCapacity;
    private Duration brewingTime;
    private String brewingType;
    private boolean hasBrewStrengthOptions;
    private boolean hasCoffeeGrinder;
    private boolean hasMilkFrother;
    private boolean isBrewing;
    private String coffeeMakerId;
    //endregion

    //region constructor
    public CoffeeMaker(String objName) {
        assignValues();
        this.coffeeMakerId = "CoffeeMaker_" + objName;
        System.out.println("Coffee Maker instance created: " + this.coffeeMakerId);
    }
    //endregion

    //region methods
    private void assignValues() {
        this.isSingleServe = false;
        this.hasTimer = true;
        this.waterCapacity = 50;
        this.brewingTime = Duration.ofMinutes(10);
        this.brewingType = "multiple";
        this.hasBrewStrengthOptions = true;
        this.hasCoffeeGrinder = false;
        this.hasMilkFrother = true;
    }

    public void startBrewing() {
        this.isBrewing = true;
        System.out.println("Started brewing coffee with " + this.coffeeMakerId + " Coffee Maker");
    }

    public void stopBrewing() {
        this.isBrewing = false;
        System.out.println("Stopped brewing coffee with " + this.coffeeMakerId + " Coffee Maker");
    }

    public void displayWaterLevel() {
        System.out.println("Water level in " + this.coffeeMakerId + " Coffee Maker: " + waterCapacity + " ounces");
    }
    //endregion
}
