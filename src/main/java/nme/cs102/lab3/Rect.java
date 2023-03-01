package nme.cs102.lab3;

import java.util.Scanner;

public class Rect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width of a rectangle: ");
        float width = sc.nextFloat();
        System.out.print("Enter the height of a rectangle: ");
        float height = sc.nextFloat();
        sc.close();

        System.out.printf("The area is %.1f.\nThe perimeter is %.1f.", height * width, 2 * (height + width));
    }
}
