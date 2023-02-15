package nme.cs102.lab10;

public class Circle extends Shape {
    private double radius;
    static final int DEFAULT_RADIUS = 5;

    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }

    public Circle(double x, double y) {
        super(x, y);
        this.radius = DEFAULT_RADIUS;
    }

    public void checkColor() {
        if (isInBoundary()) {
            color = ShapeColor.GREEN;
        } else {
            color = ShapeColor.RED;
        }
    }

    public boolean isInBoundary() {
        if (-1 * Circle.screenSize > this.x - this.radius || Circle.screenSize < this.x + this.radius) {
            return false;
        }
        if (-1 * Circle.screenSize > this.y - this.radius || Circle.screenSize < this.y + this.radius) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + " x=" + x +
                ", y=" + y + ", color=" + color + "}\n";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw() {
        StdDraw.setPenColor(color.getColor());
        StdDraw.filledCircle(x, y, radius);
    }
}
