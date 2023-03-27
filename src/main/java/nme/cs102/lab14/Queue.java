package nme.cs102.lab14;

import java.util.ArrayList;
import java.util.List;

public class Queue<E> {
  private final List<E> items = new ArrayList<>();

  public boolean enqueue(E item) {
    return items.add(item);
  }

  public E dequeue() {
    return items.remove(0);
  }

  public boolean hasItems() {
    return !items.isEmpty();
  }
}
