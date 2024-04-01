import java.io.*;

public class Main {
    public static void main(String[] args) {
        Triangle objTriangle = new Triangle(3, 4, 5);
        Rectangle objRectangle = new Rectangle(2, 6);
        Circle objCircle = new Circle(4);
        Square objSquare = new Square(3);

        // Set color for all shapes
        Shape.setColor("Red");

        // Serialization and deserialization
        serializeDeserializeObjects(objTriangle, "triangle.ser");
        serializeDeserializeObjects(objRectangle, "rectangle.ser");
        serializeDeserializeObjects(objCircle, "circle.ser");
        serializeDeserializeObjects(objSquare, "square.ser");
    }

    // Method to serialize and deserialize an object
    private static void serializeDeserializeObjects(Shape shape, String filename) {
        serializeObject(shape, filename);
        deserializeObject(filename);
    }

    // Method to serialize an object
    private static void serializeObject(Shape shape, String filename)
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename)))  //opening and closing objects with one line
        {
            objectOutputStream.writeObject(shape);
            System.out.println("Object has been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("IOException is caught during serialization");
            e.printStackTrace();
        }
    }

    // Method to deserialize an object
    private static void deserializeObject(String filename)
    {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) //opening and closing objects with one line
        {
            Shape deserializedShape = (Shape) inputStream.readObject();
            System.out.println("Object has been deserialized from " + filename);
            Shape.showShapeDetails(deserializedShape);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception is caught during deserialization");
            e.printStackTrace();
        }
    }
}
