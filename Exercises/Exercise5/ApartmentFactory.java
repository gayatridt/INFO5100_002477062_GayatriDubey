// House Rental System - Factory Design Pattern

// Concrete Creator: ApartmentFactory
class ApartmentFactory implements HouseFactory
{
    //region methods
    @Override
    public House createHouse()
    {
        return new Apartment("123 Main St", 1500);
    }
    //endregion
}
