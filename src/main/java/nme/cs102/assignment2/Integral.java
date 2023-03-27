package nme.cs102.assignment2;

import java.util.Scanner;

public class Integral {
  public static double polynomial(double[] coefficients, double x) {
    double sum = 0;
    for (int i = 0; i < coefficients.length; i++) {
      sum += coefficients[i] * Math.pow(x, i);
    }
    return sum;
  }

  public static double integral(double[] coefficients, double from, double to) {
    double[] polynomials = new double[coefficients.length + 1];
    polynomials[0] = 0;
    for (int i = 0; i < coefficients.length; i++) {
      polynomials[i + 1] = coefficients[i] / (i + 1);
    }
    return polynomial(polynomials, to) - polynomial(polynomials, from);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int terms = sc.nextInt();
      double[] coefficients = new double[terms];
      for (int i = 0; i < terms; i++) {
        coefficients[i] = sc.nextDouble();
      }
      System.out.println(integral(coefficients, sc.nextDouble(), sc.nextDouble()));
    }
  }
}
