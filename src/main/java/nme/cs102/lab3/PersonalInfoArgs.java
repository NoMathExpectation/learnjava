package nme.cs102.lab3;

public class PersonalInfoArgs {
    public static void main(String[] args) {
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        float weight = Float.parseFloat(args[2]);
        char grade = args[3].charAt(0);

        System.out.printf("You are %s.\nYou are %d years old.\nYou weigh %.1f KG\nThe highest grade you got is %c.", name, age, weight, grade);
    }
}
