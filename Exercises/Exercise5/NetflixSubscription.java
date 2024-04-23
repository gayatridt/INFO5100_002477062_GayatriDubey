// Netflix Subscription System - Singleton Design Pattern

class NetflixSubscription
{
    //region properties
    private static NetflixSubscription instance;
    //endregion

    //region constructor
    private NetflixSubscription() {}

    // Access to the single instance of NetflixSubscription
    public static NetflixSubscription getInstance()
    {
        if (instance == null)
        {
            instance = new NetflixSubscription();
        }
        return instance;
    }
    //endregion

    //region methods
    // Subscribe to Netflix
    public void subscribe()
    {
        System.out.println("You have subscribed to Netflix.");
    }
    //endregion
}