package nme.cs102.lab6;

import java.util.Scanner;

public class Lab6E2 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Please input bottom and height: ");
      double bottom = sc.nextDouble();
      double height = sc.nextDouble();
      System.out.printf("\nThe area is %f\nPlease input a, b and angle between a and b: ", MyTriangle.area(bottom, height));
      double a = sc.nextDouble();
      double b = sc.nextDouble();
      int angle = sc.nextInt();
      System.out.printf("\nThe area is %f", MyTriangle.area(a, b, angle));
    }
  }
}
