package nme.cs102.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Danganronpa {
  private static final List<String> statements = new ArrayList<>();

  private static long influence;
  private static boolean fail = false;

  private static long a = 0, b = 0, c = 0;

  private static final QReader sc = new QReader();
  private static final QWriter out = new QWriter();


  private static long medianOfStatements() {
    if (statements.isEmpty()) {
      return 0;
    }

    int[] lengths = statements.stream().mapToInt(String::length).sorted().toArray();
    return lengths[(lengths.length + 1) / 2 - 1];
  }


  private static long pairs = 0;

  private static void pairMatch(String s) {
    pairs += statements.stream().filter(x -> x.equals(s)).count();
  }

  private static void event1(String statement) {
    statements.add(statement);
  }

  private static void event2(String truth) {
    pairMatch(truth);
    influence++;

    long median = medianOfStatements();
    out.println(median);

    if (influence < median) {
      influence -= statements.size();
      fail = fail || influence < 0;
    }
  }

  private static void event3() {
    out.println(pairs);
  }

  public static void main(String[] args) {
    long n = sc.nextLong();
    influence = sc.nextLong();
    for (long i = 0; i < n; i++) {
      c += sc.nextLong();
    }

    long round = 0;
    for (round = 0; round < n; round++) {
      switch (sc.nextInt()) {
        case 1:
          event1(sc.next());
          break;
        case 2:
          event2(sc.next());
          break;
        case 3:
          event3();
          break;
        default:
      }

      a += medianOfStatements();
      b += pairs;
    }

    out.println(!fail && a * b * c >= 0 ? "Qi Fei" : "Fail");

    sc.close();
    out.close();
  }
}

// Special thanks to https://github.com/Penguin134/CS102A22S12
class QReader implements Closeable {
  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private StringTokenizer tokenizer = new StringTokenizer("");

  private String innerNextLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      return null;
    }
  }

  public boolean hasNext() {
    while (!tokenizer.hasMoreTokens()) {
      String nextLine = innerNextLine();
      if (nextLine == null) {
        return false;
      }
      tokenizer = new StringTokenizer(nextLine);
    }
    return true;
  }

  public String nextLine() {
    tokenizer = new StringTokenizer("");
    return innerNextLine();
  }

  public String next() {
    hasNext();
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  @Override
  public void close() {
    try {
      reader.close();
    } catch (IOException ignored) {
    }
  }
}

class QWriter implements Closeable {
  private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

  public void print(Object object) {
    try {
      writer.write(object.toString());
    } catch (IOException ignored) {
    }
  }

  public void println(Object object) {
    try {
      writer.write(object.toString());
      writer.write("\n");
    } catch (IOException ignored) {
    }
  }

  @Override
  public void close() {
    try {
      writer.close();
    } catch (IOException ignored) {
    }
  }
}
