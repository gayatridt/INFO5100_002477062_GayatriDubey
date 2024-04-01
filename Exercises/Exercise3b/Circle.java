import java.io.Serializable;

public class Circle extends Shape implements Serializable
{
    //region properties
    private double circRadius;
    //endregion

    //region constructor
    public Circle(double radius) {
        circRadius = radius;
    }
    //endregion

    //region methods
    @Override
    double calculateArea()
    {
        // Calculating area of circle
        return Math.PI * circRadius * circRadius;
    }

    @Override
    double calculatePerimeter()
    {
        // Calculating perimeter of circle
        return 2 * Math.PI * circRadius;
    }
    //endregion
}