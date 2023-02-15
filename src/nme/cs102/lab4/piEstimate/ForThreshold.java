package nme.cs102.lab4.piEstimate;

import java.util.Scanner;

public class ForThreshold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input threshold: ");
        double threshold = sc.nextDouble();
        sc.close();
        double pi = 0;
        int i = 1;
        for (; ; i++) {
            double diff = Math.pow(-1, i + 1) / (2 * i - 1) * 4;
            if (Math.abs(diff) < threshold) {
                break;
            }
            pi += diff;
        }
        System.out.printf("The estimation of pi is %f.\nUsed %d terms.", pi, i);
    }
}
