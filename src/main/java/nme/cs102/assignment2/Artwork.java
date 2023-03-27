package nme.cs102.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Artwork {
  static class Point {
    public final int x;
    public final int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static final List<Point> pointList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    sc.close();

    putPoint(-2, 0);
    for (int i = -1; i < k; i++) {
      if (i % 2 == 0) {
        putUp(2 * i);
      } else {
        putDown(2 * i);
      }
    }

    printAll();
  }

  public static void putPoint(int x, int y) {
    pointList.add(new Point(x, y));
  }

  public static void putLine(int x) {
    putPoint(x + 1, 0);
    putPoint(x + 2, 0);
  }

  public static void putUp(int x) {
    putLine(x);
    putPoint(x, 1);
    putPoint(x + 2, 1);
    putPoint(x, 2);
    putPoint(x + 1, 2);
    putPoint(x + 2, 2);
  }

  public static void putDown(int x) {
    putLine(x);
    putPoint(x, -1);
    putPoint(x + 2, -1);
    putPoint(x, -2);
    putPoint(x + 1, -2);
    putPoint(x + 2, -2);
  }

  public static void printPoint(Point p) {
    System.out.printf("%d %d\n", p.x, p.y);
  }

  public static void printAll() {
    pointList.remove(new Point(0, 0));
    System.out.println(pointList.size());
    for (Point p : pointList) {
      printPoint(p);
    }
  }
}
