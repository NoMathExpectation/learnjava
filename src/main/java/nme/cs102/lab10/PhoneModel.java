package nme.cs102.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum PhoneModel {
  IPHONE(9999), HUAWEI(8888), PIXEL(6666), SAMSUNG(9399), LG(5588);

  private int price;

  PhoneModel(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return name() + " price:" + price;
  }

  public static void main(String[] args) {
    System.out.println("Your budget: ");
    try (Scanner sc = new Scanner(System.in)) {
      int budget = sc.nextInt();
      List<PhoneModel> models = new ArrayList<>();
      for (PhoneModel p : PhoneModel.values()) {
        if (p.price <= budget) {
          models.add(p);
        }
      }
      if (models.isEmpty()) {
        System.out.println("No suitable phone.");
        return;
      }
      for (PhoneModel p : models) {
        System.out.println(p);
      }
    }
  }
}
