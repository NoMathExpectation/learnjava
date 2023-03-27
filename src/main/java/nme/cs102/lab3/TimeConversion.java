package nme.cs102.lab3;

import java.util.Scanner;

public class TimeConversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input the number of seconds: ");
    long seconds = sc.nextLong();
    sc.close();
    System.out.printf("The equivalent time is %d hours, %d minutes and %d seconds.", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
  }
}
