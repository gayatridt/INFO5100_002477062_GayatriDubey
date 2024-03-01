public class Triangle extends Shape {
    //region properties
    private double triSide1, triSide2, triSide3;
    private double triPerimeter;
    //endregion

    //region constructor
    public Triangle(double side1, double side2, double side3) {
        triSide1 = side1;
        triSide2 = side2;
        triSide3 = side3;
        triPerimeter = triSide1 + triSide2 + triSide3;
    }
    //endregion

    //region methods
    @Override
    public double calculateArea() {
        // Calculating area of triangle from its 3 sides using Heron's formula
        // Area = √[s(s-a)(s-b)(s-c)]
        // Here, "s" is the semi-perimeter of the triangle, i.e., s = (a + b + c)/2

        double semiPerimeter = (triPerimeter)/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triSide1) * (semiPerimeter - triSide2) * (semiPerimeter - triSide3));
    }

    @Override
    public double calculatePerimeter() {
        // Calculating perimeter of triangle
        return triPerimeter;
    }
    //endregion
}
