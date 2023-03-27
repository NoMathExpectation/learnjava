package nme.cs102.lab8;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      while (true) {
        String s = sc.nextLine();
        if (s.equals("quit")) {
          break;
        }

        char[] chars = s.toCharArray();
        char[] reversedChars = new char[chars.length];
        for (int i = 1; i <= chars.length; i++) {
          reversedChars[chars.length - i] = chars[i - 1];
        }
        System.out.printf("%s is%s a palindrome.\n", s, Arrays.equals(chars, reversedChars) ? "" : " not");
      }
    }
  }
}
