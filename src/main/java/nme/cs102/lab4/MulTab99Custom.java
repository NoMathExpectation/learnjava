package nme.cs102.lab4;

import java.util.Scanner;

public class MulTab99Custom {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    while (true) {
      System.out.print("Input a number between 1 and 9, enter 0 to exit: ");
      n = sc.nextInt();
      if (n < 0 || n > 9) {
        System.out.println("Invalid input!");
        continue;
      }
      if (n == 0) {
        break;
      }
      for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < i + 1; j++) {
          System.out.printf("%d * %d = %d\t", j, i, i * j);
        }
        System.out.println();
      }
    }
    sc.close();
  }
}
