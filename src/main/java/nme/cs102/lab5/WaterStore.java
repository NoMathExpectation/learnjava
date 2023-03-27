package nme.cs102.lab5;

import java.util.Scanner;

public class WaterStore {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input the length of the array: ");
    int[] array = new int[sc.nextInt()];
    for (int i = 0; i < array.length; i++) {
      array[i] = sc.nextInt();
    }
    sc.close();

    int storage = 0;
    for (int i = 0; i < array.length - 2; i++) {
      int preStorage = 0;
      for (int j = array[i]; j > array[i + 1]; j--) {
        for (int k = i + 1; k < array.length; k++) {
          if (k == array.length - 1) {
            preStorage = 0;
            break;
          }
          if (j <= array[k]) {
            i = k - 1;
            break;
          }
          preStorage += j - array[k];
        }
        if (preStorage != 0) {
          break;
        }
      }
      storage += preStorage;
    }

    System.out.print(storage);
  }
}