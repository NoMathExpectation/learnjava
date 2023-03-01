package nme.cs102.lab11.ex2;

public class Exercise2 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[6];
        for (int i = 0; i < animals.length; i++) {
            if (i % 2 == 0) {
                animals[i] = new Monkey();
            } else {
                animals[i] = new Human();
            }
        }

        for (Animal m : animals) {
            m.speak();
        }
    }
}
