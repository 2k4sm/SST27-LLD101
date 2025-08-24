
public class Demo05 {
    static int areaAfterResize(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return r.area();
    }

    static int squareAreaAfterResize(Square s) {
        s.setSide(5);
        return s.area();
    }

    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle())); // 20
        System.out.println(squareAreaAfterResize(new Square())); // 25

        // Demonstrate polymorphism with Shape interface
        Shape[] shapes = { new Rectangle(3, 4), new Square(5) };
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.area());
        }
    }
}
