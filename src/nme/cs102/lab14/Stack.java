package nme.cs102.lab14;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private final List<E> items = new ArrayList<>();

    public boolean push(E item) {
        return items.add(item);
    }

    public E pop() {
        return items.remove(items.size() - 1);
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }
}
