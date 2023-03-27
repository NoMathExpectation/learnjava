package nme.cs102.lab4;

import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {
  static int magicNum = new Random().nextInt(10);
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.print("Input a number between 0 and 9: ");
      int num = sc.nextInt();
      if (num > magicNum) {
        System.out.println("Too big! Please try again.");
      } else if (num < magicNum) {
        System.out.println("Too small! Please try again.");
      } else {
        System.out.println("Congratulations!");
        break;
      }
    }
    sc.close();
  }
}
