package nme.cs102.lab4.piEstimate;

import java.util.Scanner;

public class WhileNTerms {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input series term number: ");
    int n = sc.nextInt();
    sc.close();
    double pi = 0;
    int i = 1;
    while (i <= n) {
      pi += Math.pow(-1, i + 1) / (2 * i - 1);
      i++;
    }
    System.out.printf("The estimation of pi is %f.", pi * 4);
  }
}
