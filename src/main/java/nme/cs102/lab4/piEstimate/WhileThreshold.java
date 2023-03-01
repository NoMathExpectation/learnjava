package nme.cs102.lab4.piEstimate;

import java.util.Scanner;

public class WhileThreshold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input threshold: ");
        double threshold = sc.nextDouble();
        sc.close();
        double pi = 0;
        int i = 1;
        while (true) {
            double diff = Math.pow(-1, i + 1) / (2 * i - 1) * 4;
            if (Math.abs(diff) < threshold) {
                break;
            }
            pi += diff;
            i++;
        }
        System.out.printf("The estimation of pi is %f.\nUsed %d terms.", pi, i);
    }
}
