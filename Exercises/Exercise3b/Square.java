import java.io.Serializable;

public class Square extends Shape implements Serializable
{
    //region properties
    private double sqrSide;
    //endregion

    //region constructor
    public Square(double side) {
        sqrSide = side;
    }
    //endregion

    //region methods
    @Override
    public double calculateArea() {
        // Calculating area of square
        return sqrSide * sqrSide;
    }

    @Override
    public double calculatePerimeter() {
        // Calculating perimeter of square
        return 4 * sqrSide;
    }
    //endregion
}