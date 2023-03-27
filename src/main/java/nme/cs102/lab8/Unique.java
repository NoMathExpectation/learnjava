package nme.cs102.lab8;

import java.util.Scanner;

public class Unique {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.nextLine();
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < s.length(); i++) {
        if (!sb.toString().contains(s.substring(i, i + 1))) {
          sb.append(s.charAt(i));
        }
      }

      System.out.println(sb);
    }
  }
}
