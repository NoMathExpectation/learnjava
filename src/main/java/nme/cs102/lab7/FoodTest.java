package nme.cs102.lab7;

import java.util.ArrayList;
import java.util.List;

public class FoodTest {
    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(1, "pizza", "Seafood", 11, 12));
        foods.add(new Food(2, "pizza", "Beef", 9, 10));
        foods.add(new Food(3, "fried rice", "Seafood", 5, 12));
        foods.add(new Food(4, "noodles", "Beef", 6, 14));

        System.out.println("Menu:");
        for(Food f: foods) {
            System.out.printf("[id] %-2d [type] %-10s[name] %-12s[size] %-2d (inches)  [price] %-5.2f $\n", f.getId(), f.getType(), f.getName(), f.getSize(), f.getPrice());
        }
    }
}
