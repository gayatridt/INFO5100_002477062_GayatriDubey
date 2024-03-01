//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Triangle objTriangle = new Triangle(3, 4, 5);
        Rectangle objRectangle = new Rectangle(2, 6);
        Circle objCircle = new Circle(4);
        Square objSquare = new Square(3);

        Shape.setColor("Red");

        Shape.showShapeDetails(objTriangle);
        Shape.showShapeDetails(objRectangle);
        Shape.showShapeDetails(objCircle);
        Shape.showShapeDetails(objSquare);
    }
}