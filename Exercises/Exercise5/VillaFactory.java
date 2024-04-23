// House Rental System - Factory Design Pattern

// Concrete Creator: VillaFactory
class VillaFactory implements HouseFactory
{
    //region methods
    @Override
    public House createHouse() {
        return new Villa("456 Rose St", 3000);
    }
    //endregion
}
