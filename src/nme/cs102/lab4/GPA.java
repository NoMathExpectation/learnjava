package nme.cs102.lab4;

import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int points = 0;
        while (true) {
            int point = sc.nextInt();
            if (point == -1) {
                break;
            }
            int score = sc.nextInt();
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
            total += gpa * point;
            points += point;
        }
        sc.close();
        System.out.printf("Your GPA is %.1f.", (double) total / points);
    }
}
