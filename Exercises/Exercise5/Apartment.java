// House Rental System - Factory Design Pattern

// Concrete Product: Apartment
class Apartment implements House
{
    //region properties
    private String strAddress;
    private double dblRent;
    //endregion

    //region constructor
    public Apartment(String address, double rent)
    {
        this.strAddress = address;
        this.dblRent = rent;
    }
    //endregion

    //region methods
    // Display information about the apartment
    @Override
    public void displayInfo()
    {
        System.out.println("Apartment: " + strAddress + ", Rent: $" + dblRent);
    }
    //endregion
}


