package nme.cs102.lab6;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Input nth term of fibonacci sequence: ");
      int term = sc.nextInt();
      System.out.printf("The number of position %d in the sequence is %s.", term, fibonacci(term).toString());
    }
  }

  public static final Map<Integer, BigInteger> fibonacci = new HashMap<>();

  public static BigInteger fibonacci(int term) throws IllegalArgumentException {
    if (term < 0) {
      throw new IllegalArgumentException("Must be positive");
    }
    if (term == 1 || term == 2) {
      return BigInteger.ONE;
    }
    return fibonacci.computeIfAbsent(term, x -> fibonacci(x - 1).add(fibonacci(x - 2)));
  }
}
