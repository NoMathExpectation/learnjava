package nme.cs102.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftOpening {
  public static List<Food> generateMenu() {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food(1, "pizza", "Seafood", 11, 12));
    foods.add(new Food(2, "pizza", "Beef", 9, 10));
    foods.add(new Food(3, "fried rice", "Seafood", 5, 12));
    foods.add(new Food(4, "noodles", "Beef", 6, 14));
    return foods;
  }

  public static void getMenu(List<Food> foods) {
    System.out.println("Welcome! This is the menu:");
    for (Food f : foods) {
      System.out.printf("[id] %-2d [type] %-10s[name] %-12s[size] %-2d (inches)  [price] %-5.2f $\n", f.getId(), f.getType(), f.getName(), f.getSize(), f.getPrice());
    }
  }

  public static User generateUser(Scanner in) {
    User user = new User();
    System.out.print("Input name: ");
    user.setUser(in.nextLine());
    System.out.print("Input balance: ");
    user.setMoney(in.nextDouble());
    System.out.print("Input password: ");
    in.nextLine();
    user.setPassword(in.nextLine());
    return user;
  }

  public static void userConsume(List<Food> foods, User user, Scanner in) {
    getMenu(foods);
    System.out.println("What would you like to eat? Type id to select, or type 0 to exit.");

    double sum = 0;
    while (true) {
      System.out.print("Food id: ");
      int id = in.nextInt();
      if (id == 0) {
        break;
      }
      System.out.print("Count: ");
      int amount = in.nextInt();

      List<Food> selected = foods.stream().filter(f -> f.getId() == id).collect(Collectors.toList());
      for (Food food : selected) {
        sum += food.getPrice() * amount;
      }
    }

    System.out.println("End of the order.");
    if (user.expense(sum, in)) {
      System.out.println("Thank you for your ordering! Enjoy your food.");
    } else {
      System.out.println("Order failed due to payment failed.");
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    User user = generateUser(in);
    user.introduce();
    userConsume(generateMenu(), user, in);
    user.introduce();
    in.close();
  }
}
