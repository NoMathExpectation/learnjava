package nme.cs102.lab11.ex1;

public class Exercise1 {
    public static void main(String[] args) {
        Monkey[] mArray = new Monkey[6];
        for (int i = 0; i < mArray.length; i++) {
            if (i % 2 == 0) {
                mArray[i] = new Monkey();
            } else {
                mArray[i] = new Human();
            }
        }

        for (Monkey m : mArray) {
            m.speak();
        }
    }
}
