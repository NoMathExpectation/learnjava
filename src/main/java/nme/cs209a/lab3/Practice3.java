package nme.cs209a.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Practice3 {
  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      while (true) {
        System.out.println("Please input the function No:");
        System.out.println("1 - Get even numbers");
        System.out.println("2 - Get odd numbers");
        System.out.println("3 - Get prime numbers");
        System.out.println("4 - Get prime numbers that are bigger than 5");
        System.out.println("0 - Quit");

        int op = sc.nextInt();
        if (op <= 0) {
          break;
        }

        System.out.println("Input size of the list:");
        int size = sc.nextInt();

        System.out.println("Input elements of the list:");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          list.add(sc.nextInt());
        }

        switch (op) {
          case 1:
            list = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
            break;
          case 2:
            list = list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
            break;
          case 3:
            list = list.stream().filter(Practice3::isPrime).collect(Collectors.toList());
            break;
          case 4:
            list = list.stream().filter(x -> x > 5 && isPrime(x)).collect(Collectors.toList());
            break;
          default:
            break;
        }

        System.out.println("Filter results:");
        System.out.println(list);
      }
    }
  }
}
