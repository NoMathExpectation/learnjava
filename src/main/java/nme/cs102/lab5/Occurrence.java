package nme.cs102.lab5;

import java.util.Scanner;

public class Occurrence {
  public static void main(String[] args) {
    int[] occurrence = new int[100];
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the integers between 1 and 100: ");
    while (true) {
      try {
        int num = sc.nextInt();
        if (num == 0) {
          break;
        }
        occurrence[num - 1]++;
      } catch (IndexOutOfBoundsException ignored) {
      }
    }

    for (int i = 0; i < occurrence.length; i++) {
      if (occurrence[i] != 0) {
        System.out.printf("%d occurs %d time%s\n", i + 1, occurrence[i], occurrence[i] > 1 ? "s" : "");
      }
    }
  }
}
