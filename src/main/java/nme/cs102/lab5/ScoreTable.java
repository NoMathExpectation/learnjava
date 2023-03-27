package nme.cs102.lab5;

import java.util.Scanner;

public class ScoreTable {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Input the number of subjects: ");
    int subjects = sc.nextInt();

    System.out.print("Input the number of students: ");
    int students = sc.nextInt();

    int[][] scores = new int[subjects][students];

    for (int i = 0; i < subjects; i++) {
      for (int j = 0; j < students; j++) {
        scores[i][j] = sc.nextInt();
      }
    }

    sc.close();

    System.out.print("\t\t\t");
    for (int i = 0; i < subjects; i++) {
      System.out.printf("Course%d\t", i + 1);
    }
    System.out.println("Average");

    for (int i = 0; i < students; i++) {
      float total = 0;
      System.out.printf("Student%d\t", i + 1);
      for (int j = 0; j < subjects; j++) {
        total += scores[j][i];
        System.out.printf("%d\t\t", scores[j][i]);
      }
      System.out.printf("%.2f\n", total / subjects);
    }

    System.out.print("Average\t\t");
    for (int i = 0; i < subjects; i++) {
      float total = 0;
      for (int j = 0; j < students; j++) {
        total += scores[i][j];
      }
      System.out.printf("%.2f\t", total / students);
    }
  }
}
