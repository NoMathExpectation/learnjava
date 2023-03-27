package nme.cs102.assignment4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BigBinary implements Comparable<BigBinary> {
  private Deque<Integer> oneBits = new LinkedList<>();
  private boolean isNegative;

  public BigBinary(int[] bits, boolean positive) {
    if (bits == null) {
      isNegative = !positive;
      return;
    }

    bits = Arrays.copyOf(bits, bits.length);

    for (int i = bits.length - 1; i > 0; i--) {
      if (bits[i] < 0) {
        bits[i - 1] += (bits[i] - 1) / 2;
        bits[i] = -bits[i] % 2;
      }

      if (bits[i] > 1) {
        bits[i - 1] += bits[i] / 2;
        bits[i] %= 2;
      }

      if (bits[i] == 1) {
        oneBits.offerLast(bits.length - i - 1);
      }
    }

    if (bits[0] < 0) {
      positive = !positive;
      bits[0] = -bits[0] - 1;
    }

    int i = bits.length - 1;
    while (bits[0] > 1) {
      if (bits[0] % 2 == 1) {
        oneBits.offerLast(i);
      }
      bits[0] /= 2;
      i++;
    }

    if (bits[0] == 1) {
      oneBits.offerLast(i);
    }

    isNegative = !positive;
  }

  public BigBinary(int[] bits) {
    this(bits, true);
  }

  @Override
  public String toString() {
    if (oneBits.isEmpty()) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();

    if (isNegative) {
      sb.append('-');
    }

    Integer[] oneBitsCopy = oneBits.toArray(new Integer[0]);
    int high = oneBitsCopy[oneBitsCopy.length - 1];
    sb.append(1);

    for (int i = oneBitsCopy.length - 2; i >= 0; i--) {
      int low = oneBitsCopy[i];
      for (int j = low + 1; j < high; j++) {
        sb.append("0");
      }
      sb.append(1);
      high = low;
    }

    for (int j = 0; j < high; j++) {
      sb.append("0");
    }

    return sb.toString();
  }

  @Override
  public int compareTo(BigBinary another) {
    if (isNegative && !another.isNegative) {
      return another.oneBits.size();
    }

    if (!isNegative && another.isNegative) {
      return oneBits.size();
    }

    int reversed = 1;
    if (isNegative && another.isNegative) {
      reversed = -1;
    }

    Deque<Integer> thisBits = new LinkedList<>(oneBits);
    Deque<Integer> anotherBits = new LinkedList<>(another.oneBits);

    while (!thisBits.isEmpty() && !anotherBits.isEmpty()) {
      int a = thisBits.removeLast();
      int b = anotherBits.removeLast();
      if (a - b != 0) {
        return (a - b) * reversed;
      }
    }

    if (thisBits.isEmpty()) {
      return anotherBits.size() * reversed;
    } else {
      return thisBits.size() * reversed;
    }
  }

  public BigBinary addNoChange(BigBinary another) {
    if (another == null) {
      return this;
    }

    if (isNegative) {
      return minusNoChange().minusNoChange(another).minusNoChange();
    }

    if (another.isNegative) {
      return minusNoChange(another.minusNoChange());
    }

    int length = Math.max(oneBits.getLast(), another.oneBits.getLast()) + 1;
    int[] addBits = new int[length];

    for (int oneBit : oneBits) {
      addBits[length - oneBit - 1] += 1;
    }

    for (int oneBit : another.oneBits) {
      addBits[length - oneBit - 1] += 1;
    }

    return new BigBinary(addBits);
  }

  public BigBinary add(BigBinary another) {
    BigBinary result = addNoChange(another);
    oneBits = new LinkedList<>(result.oneBits);
    isNegative = result.isNegative;
    return this;
  }

  public static BigBinary add(BigBinary one, BigBinary another) {
    if (one == null) {
      return another;
    }

    return one.addNoChange(another);
  }

  public BigBinary minusNoChange(BigBinary another) {
    if (another == null) {
      return this;
    }

    if (isNegative) {
      return minusNoChange().addNoChange(another).minusNoChange();
    }

    if (another.isNegative) {
      return addNoChange(another.minusNoChange());
    }

    if (compareTo(another) < 0) {
      return another.minusNoChange(this).minusNoChange();
    }

    int length = Math.max(oneBits.getLast(), another.oneBits.getLast()) + 1;
    int[] minusBits = new int[length];

    for (int oneBit : oneBits) {
      minusBits[length - oneBit - 1] += 1;
    }

    for (int oneBit : another.oneBits) {
      minusBits[length - oneBit - 1] -= 1;
    }

    return new BigBinary(minusBits);
  }

  public BigBinary minusNoChange() {
    BigBinary result = new BigBinary(null, isNegative);
    result.oneBits.addAll(oneBits);
    return result;
  }

  public BigBinary minus(BigBinary another) {
    BigBinary result = minusNoChange(another);
    oneBits = new LinkedList<>(result.oneBits);
    isNegative = result.isNegative;
    return this;
  }

  public static BigBinary minus(BigBinary one, BigBinary another) {
    if (one == null) {
      return another;
    }

    return one.minusNoChange(another);
  }

  public BigBinary minus() {
    isNegative = !isNegative;
    return this;
  }

  public BigBinary multiplyNoChange(BigBinary another) {
    if (another == null) {
      return this;
    }

    if (oneBits.isEmpty() || another.oneBits.isEmpty()) {
      return new BigBinary(null);
    }

    if (isNegative ^ another.isNegative) {
      return minusNoChange().multiplyNoChange(another).minusNoChange();
    }

    Integer[] base, shift;
    if (oneBits.size() > another.oneBits.size()) {
      base = oneBits.toArray(new Integer[0]);
      shift = another.oneBits.toArray(new Integer[0]);
    } else {
      base = another.oneBits.toArray(new Integer[0]);
      shift = oneBits.toArray(new Integer[0]);
    }

    int[] baseBits = new int[base[base.length - 1] + 1];
    for (int i : base) {
      baseBits[baseBits.length - i - 1] = 1;
    }

    int[] result = new int[base[base.length - 1] + shift[shift.length - 1] + 1];

    for (int i : shift) {
      for (int j = 0; j < baseBits.length; j++) {
        result[result.length - baseBits.length - i + j] += baseBits[j];
      }
    }

    return new BigBinary(result);
  }

  public BigBinary multiply(BigBinary another) {
    BigBinary result = multiplyNoChange(another);
    oneBits = new LinkedList<>(result.oneBits);
    isNegative = result.isNegative;
    return this;
  }

  public static BigBinary multiply(BigBinary one, BigBinary another) {
    if (one == null) {
      return another;
    }

    return one.multiplyNoChange(another);
  }

  public static void main(String[] args) {
    long start = System.nanoTime();
    BigBinary a = new BigBinary(new int[]{0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0}, true);
    BigBinary b = new BigBinary(new int[]{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, true);
    System.out.println(a.multiplyNoChange(b));
    long end = System.nanoTime();
    System.out.println(end - start);
  }
}
