package nme.cs102.lab10;

public class Shape {
  protected double x;
  protected double y;
  protected ShapeColor color = ShapeColor.GRAY;
  protected static int screenSize = 10;

  public Shape(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return " x=" + x + ", y=" + y + ", color=" + color;
  }

  public ShapeColor getColor() {
    return color;
  }

  public void setColor(ShapeColor color) {
    this.color = color;
  }

  public static int getScreenSize() {
    return screenSize;
  }

  public static void setScreenSize(int screenSize) {
    Shape.screenSize = screenSize;
  }
}
