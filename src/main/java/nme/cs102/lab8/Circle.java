package nme.cs102.lab8;

import java.util.Random;

public class Circle {
  public final int id;
  public final double x;
  public final double y;
  public final double radius;

  public Circle(int id, double x, double y, double radius) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double distanceToOrigin() {
    return Math.sqrt(x * x + y * y);
  }

  public double area() {
    return radius * radius * Math.PI;
  }

  @Override
  public String toString() {
    return String.format("Circle #%d: x = %f, y = %f, r = %f", id, x, y, radius);
  }

  public static final Random RANDOM = new Random();

  public static double generateRandom(double min, double max) {
    return min + RANDOM.nextDouble() * (max - min);
  }

  public static void main(String[] args) {
    int n = (int) generateRandom(5, 10);
    double smallestArea = Double.MAX_VALUE;
    int smallestAreaId = 0;
    double farthestDistance = 0;
    int farthestDistanceId = 0;
    for (int i = 0; i < n; i++) {
      Circle circle = new Circle(i + 1, generateRandom(2, 5), generateRandom(2, 5), generateRandom(1, 3));
      System.out.printf("%s\n", circle);
      if (circle.area() < smallestArea) {
        smallestArea = circle.area();
        smallestAreaId = circle.id;
      }
      if (circle.distanceToOrigin() > farthestDistance) {
        farthestDistance = circle.distanceToOrigin();
        farthestDistanceId = circle.id;
      }
    }
    System.out.printf("The smallest circle: %d\nThe farthest circle: %d", smallestAreaId, farthestDistanceId);
  }
}
