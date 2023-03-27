package nme.cs102.assignment1;

import java.util.Scanner;

public class PCR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    if (String.valueOf(sc.nextInt()).length() != 8) {
      System.out.print("Not valid");
      sc.close();
      return;
    }

    String record = sc.next();
    sc.close();

    if (record.length() != 7) {
      System.out.print("Not valid");
      return;
    }

    int testedDays = 0;
    int consecutiveNotTestedDays = 0;
    boolean satisfied = true;
    for (int i = 0; i < 7; i++) {
      switch (record.charAt(i)) {
        case 'Y':
          testedDays++;
          consecutiveNotTestedDays = 0;
          break;
        case 'N':
          if (++consecutiveNotTestedDays > 2) {
            satisfied = false;
          }
          break;
        default:
          System.out.print("Not valid");
          return;
      }
    }

    if (testedDays > 3 && satisfied) {
      System.out.print("Good, keep it up!");
    } else {
      System.out.print("Has not participated in Nucleic Acid PCR tests as required!");
    }
  }
}
