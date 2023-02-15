package nme.cs102.lab13;

public class Circle implements Geometry{
    public final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public char draw() {
        return '\u25CF';
    }
}

