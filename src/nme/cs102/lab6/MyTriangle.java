package nme.cs102.lab6;

import java.util.Scanner;

public class MyTriangle {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                double a = sc.nextDouble();
                if (a == -1) {
                    System.out.println("Bye~");
                    break;
                }
                double b = sc.nextDouble();
                double c = sc.nextDouble();

                if (isValid(a, b, c)) {
                    System.out.printf("Area: %f\nPerimeter: %f\n", area(a, b, c), perimeter(a, b, c));
                }
                else {
                    System.out.println("The input is invalid.");
                }
            }
        }
    }

    public static double area(double a, double b, double c) {
        return .5 * a * b * Math.sqrt(1 - Math.pow((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / 2 / a / b, 2));
    }

    public static double area(double bottom, double height) {
        return .5 * bottom * height;
    }

    public static double area(double a, double b, int angleOfAandB) {
        return .5 * a * b * Math.sin(angleOfAandB * Math.PI / 180);
    }

    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static boolean isValid(double a, double b, double c) {
        return a < b + c && b < a + c && c < a + b;
    }
}
