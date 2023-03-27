package nme.cs102.lab3;

import java.util.Scanner;

public class PersonalInfo {
  public static void main(String[] args) {
    String name;
    int age;
    float weight;
    char grade;

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter your name: ");
    name = sc.next();
    System.out.print("\nEnter your age: ");
    age = sc.nextInt();
    System.out.print("\nEnter your weight in KG: ");
    weight = sc.nextFloat();
    System.out.print("\nEnter your highest grade in last semester: ");
    grade = sc.next().charAt(0);
    sc.close();

    System.out.printf("You are %s.\nYou are %d years old.\nYou weigh %.1f KG\nThe highest grade you got is %c.", name, age, weight, grade);
  }
}
