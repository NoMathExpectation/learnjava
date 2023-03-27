package nme.cs102.lab8;

import java.util.Scanner;

public class Occurrence {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.nextLine();
      String find = sc.nextLine();
      int occurrence = 0;
      while (true) {
        int start = s.indexOf(find);
        if (start == -1) {
          break;
        }
        occurrence++;
        s = s.substring(start + find.length());
      }
      System.out.println(occurrence);
    }
  }
}
