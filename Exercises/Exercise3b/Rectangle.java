import java.io.Serializable;

public class Rectangle extends Shape implements Serializable
{
    //region properties
    private double recLength, recWidth;
    //endregion

    //region constructor
    public Rectangle(double length, double width)
    {
        recLength = length;
        recWidth = width;
    }
    //endregion

    //region methods
    @Override
    public double calculateArea()
    {
        // Calculating area of rectangle
        return recLength * recWidth;
    }

    @Override
    public double calculatePerimeter()
    {
        // Calculating perimeter of rectangle
        return 2 * (recLength + recWidth);
    }
    //endregion
}