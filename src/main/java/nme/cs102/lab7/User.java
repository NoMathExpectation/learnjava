package nme.cs102.lab7;

import java.util.Scanner;

public class User {
    private String account;
    private String password;
    private double money;

    public void setUser(String account) {
        this.account = account;
    }

    public String getUser() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void introduce() {
        System.out.printf("%s has a balance of %.2f dollars.\n", account, money);
    }

    public boolean expense(double value, Scanner in) {
        if (value > money) {
            System.out.printf("Try to withdraw %.2f dollars but no sufficient funds.\n", value);
            return false;
        }

        System.out.printf("Try to withdraw %.2f dollars.\n", value);
        System.out.print("Enter password: ");
        in.nextLine();
        if (in.nextLine().equals(password)) {
            money -= value;
            System.out.printf("Withdrawn %.2f dollars and remains %.2f dollars.\n", value, money);
            return true;
        }
        System.out.println("Wrong password!");
        return false;
    }

    public double income(double value) {
        money += value;
        System.out.printf("Deposited %.2f dollars, now have %.2f dollars.\n", value, money);
        return money;
    }
}
