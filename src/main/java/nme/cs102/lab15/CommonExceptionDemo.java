package nme.cs102.lab15;

import java.util.Scanner;

public class CommonExceptionDemo {
  public static void main(String[] args) {
    System.out.println("Exceptions:");
    for (ExceptionEnum value : ExceptionEnum.values()) {
      System.out.println(value.toString() + '(' + value.ordinal() + ')');
    }

    System.out.println("Input exception type you want to trigger: ");
    int num;
    ExceptionEnum exceptionIndex = null;
    try (Scanner sc = new Scanner(System.in)) {
      num = sc.nextInt();
      for (ExceptionEnum value : ExceptionEnum.values()) {
        if (value.ordinal() == num) {
          exceptionIndex = value;
        }
      }
      if (exceptionIndex == null) {
        throw new IllegalArgumentException(String.valueOf(num));
      }
    } catch (Exception e) {
      System.out.println(e.toString() + ": " + e.getMessage());
      return;
    }

    switch (exceptionIndex) {
      case ARITHMETIC: {
        System.out.println(1 / 0);
      }
      break;
      case INDEXOUTOFBOUNDS: {
        int[] anArray = new int[3];
        System.out.println(anArray[3]);
      }
      break;
      case NEGATIVEARRAYSIZE: {
        int[] anArray = new int[-1];
      }
      break;
      case NULLPOINTER: {
        String[] strs = new String[3];
        System.out.println(strs[0].length());
      }
      break;
      case NUMBERFORMAT: {
        Integer.parseInt("abc");
      }
      break;
      case CLASSCAST: {
        Object o = new Object();
        Integer i = (Integer) o;
      }
      break;
    }
  }
}

enum ExceptionEnum {
  ARITHMETIC,
  INDEXOUTOFBOUNDS,
  NEGATIVEARRAYSIZE,
  NULLPOINTER,
  NUMBERFORMAT,
  CLASSCAST;
}
