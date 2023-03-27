package nme.cs102.lab13;

public class Rectangle implements Geometry {
  public final double height;
  public final double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public double area() {
    return height * width;
  }

  @Override
  public double perimeter() {
    return (height + width) * 2;
  }

  @Override
  public char draw() {
    return '\u25AC';
  }
}
