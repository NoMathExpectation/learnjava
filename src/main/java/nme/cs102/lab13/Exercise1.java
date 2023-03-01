package nme.cs102.lab13;

public class Exercise1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3.0, 2.0);
        Circle circle = new Circle(3.0);
        Geometry[] geometries = {rect, circle};
        for(Geometry g: geometries) {
            System.out.printf("%c : perimeter = %.2f, area = %.2f\n", g.draw(), g.perimeter(), g.area());
        }
    }
}
