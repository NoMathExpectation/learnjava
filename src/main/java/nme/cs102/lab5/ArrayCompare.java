package nme.cs102.lab5;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCompare {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the length of arrays: ");
    int length = sc.nextInt();

    int[] a = new int[length];
    int[] b = new int[length];

    System.out.printf("Enter the 1st array of size %d: ", length);
    for (int i = 0; i < length; i++) {
      a[i] = sc.nextInt();
    }
    System.out.printf("Enter the 2nd array of size %d: ", length);
    for (int i = 0; i < length; i++) {
      b[i] = sc.nextInt();
    }
    sc.close();

    if (Arrays.equals(a, b)) {
      System.out.print("Two arrays have same values");
    } else {
      System.out.print("Two arrays are different");
    }
  }
}
