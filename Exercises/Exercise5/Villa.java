// House Rental System - Factory Design Pattern

// Concrete Product: Villa
class Villa implements House
{
    //region properties
    private String strAddress;
    private double dblRent;
    //endregion

    //region constructor
    public Villa(String address, double rent)
    {
        this.strAddress = address;
        this.dblRent = rent;
    }
    //endregion

    //region methods
    @Override
    public void displayInfo()
    {
        System.out.println("Villa: " + strAddress + ", Rent: $" + dblRent);
    }
    //endregion
}
