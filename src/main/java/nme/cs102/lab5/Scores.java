package nme.cs102.lab5;

import java.util.Arrays;
import java.util.Scanner;

public class Scores {
  public static void main(String[] args) {
    double[] scores = new double[10];
    Scanner sc = new Scanner(System.in);

    System.out.print("Please input 10 scores of these students: ");
    for (int i = 0; i < 10; i++) {
      scores[i] = sc.nextFloat();
    }
    sc.close();

    Arrays.sort(scores);
    scores[0] = 0;
    scores[9] = 0;
    System.out.printf("Average score is %.2f", Arrays.stream(scores).sum() / 8);
  }
}
