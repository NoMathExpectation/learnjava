package nme.cs102.assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class Pigeon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] pigeons = new int[l];
        int[] destinations = new int[l];

        for (int i = 0; i < l; i++) {
            pigeons[i] = sc.nextInt();
        }
        for (int i = 0; i < l; i++) {
            destinations[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(pigeons);
        Arrays.sort(destinations);
        int t = 0;
        for (int i = 0; i < l; i++) {
            t = Integer.max(t, Math.abs(destinations[i] - pigeons[i]));
        }
        System.out.println(t);
    }
}
