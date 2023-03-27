package nme.cs102.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Queen {
  public static boolean isValid(List<String> queens) {
    for (String queen : queens) {
      String rowNext = queen;
      String rowPrev = queen;
      String colNext = queen;
      String colPrev = queen;
      String diagNext = queen;
      String diagPrev = queen;
      String diag2Next = queen;
      String diag2Prev = queen;
      for (int i = 0; i < 7; i++) {
        rowNext = String.valueOf((char) (rowNext.charAt(0) + 1)) + rowNext.charAt(1);
        rowPrev = String.valueOf((char) (rowPrev.charAt(0) - 1)) + rowPrev.charAt(1);
        colNext = String.valueOf(colNext.charAt(0)) + (char) (colNext.charAt(1) + 1);
        colPrev = String.valueOf(colPrev.charAt(0)) + (char) (colPrev.charAt(1) - 1);
        diagNext = String.valueOf((char) (diagNext.charAt(0) + 1)) + (char) (diagNext.charAt(1) + 1);
        diagPrev = String.valueOf((char) (diagPrev.charAt(0) - 1)) + (char) (diagPrev.charAt(1) - 1);
        diag2Next = String.valueOf((char) (diag2Next.charAt(0) + 1)) + (char) (diag2Next.charAt(1) - 1);
        diag2Prev = String.valueOf((char) (diag2Prev.charAt(0) - 1)) + (char) (diag2Prev.charAt(1) + 1);
        if (queens.contains(rowNext) || queens.contains(rowPrev) || queens.contains(colNext) || queens.contains(colPrev) || queens.contains(diagNext) || queens.contains(diagPrev) || queens.contains(diag2Next) || queens.contains(diag2Prev)) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    List<String> queens = new ArrayList<>();
    try (Scanner sc = new Scanner(System.in)) {
      int tests = sc.nextInt();
      for (int i = 0; i < tests; i++) {
        queens.clear();
        for (int j = 0; j < 8; j++) {
          queens.add(sc.next());
        }
        System.out.println(isValid(queens) ? "Yes" : "No");
      }
    }
  }
}
