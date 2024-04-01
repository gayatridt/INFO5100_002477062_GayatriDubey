import java.io.Serializable;

abstract class Shape implements Serializable
{
    //region properties
    static String shapeColor;
    //endregion

    //region methods
    abstract double calculateArea();

    abstract double calculatePerimeter();

    static void setColor(String color) {
        shapeColor = color;
    }

    static void showShapeDetails(Shape shapeType)
    {
        System.out.println("Shape: " + shapeType.getClass().getSimpleName());
        System.out.println("Color: " + Shape.shapeColor);
        System.out.println("Area: " + shapeType.calculateArea());
        System.out.println("Perimeter: " + shapeType.calculatePerimeter());
        System.out.println();
    }
    //endregion
}