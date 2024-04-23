// Main Class
public class Main
{
    public static void main(String[] args)
    {
        // House Rental System: Factory Method
        HouseFactory apartmentFactory = new ApartmentFactory();
        HouseFactory villaFactory = new VillaFactory();

        House apartment = apartmentFactory.createHouse();
        House villa = villaFactory.createHouse();

        System.out.println("House Rental System:");
        apartment.displayInfo();
        villa.displayInfo();

        // Netflix Subscription System: Singleton
        NetflixSubscription netflixSubscription = NetflixSubscription.getInstance();
        System.out.println("\nNetflix Subscription System:");
        netflixSubscription.subscribe();

        // University Asset System: Observer
        MaintenanceStaff maintenanceStaff = new MaintenanceStaff();
        AssetManager assetManager = new AssetManager();
        assetManager.attach(maintenanceStaff);

        System.out.println("\nUniversity Asset System:");
        assetManager.notifyStaff();
    }
}
