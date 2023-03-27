package nme.cs102.lab3;

import java.util.Scanner;

public class GPA {
  public static void main(String[] args) {
    System.out.print("Enter your grade: ");
    Scanner sc = new Scanner(System.in);
    int score = sc.nextInt();
    sc.close();
    int gpa;
    switch (score / 10) {
      case 10:
      case 9:
        gpa = 4;
        break;
      case 8:
        gpa = 3;
        break;
      case 7:
        gpa = 2;
        break;
      case 6:
        gpa = 1;
        break;
      default:
        gpa = 0;
    }
    System.out.printf("Your GPA is %d.0.", gpa);
  }
}
