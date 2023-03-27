package nme.cs102.assignment1;

import java.util.Scanner;

public class PCRScore {
  public static void main(String[] args) {
    int violatedTimes = 0;
    try (Scanner sc = new Scanner(System.in)) {
      for (int i = 0; i < 4; i++) {
        if (!sc.hasNext()) {
          throw new IllegalArgumentException("Not valid");
        }
        if (isViolated(sc.next())) {
          violatedTimes++;
        }
      }
      if (sc.hasNext()) {
        throw new IllegalArgumentException("Not valid");
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return;
    }

    int score;
    switch (violatedTimes) {
      case 0:
        score = 100;
        break;
      case 1:
        score = 90;
        break;
      case 2:
        score = 75;
        break;
      case 3:
        score = 55;
        break;
      case 4:
        score = 30;
        break;
      default:
        return;
    }

    System.out.print(score);
  }

  public static boolean isViolated(String args) throws IllegalArgumentException {
    if (args.length() != 7) {
      throw new IllegalArgumentException("Not valid");
    }

    int testedDays = 0;
    int consecutiveNotTestedDays = 0;
    boolean satisfied = true;
    for (int i = 0; i < 7; i++) {
      switch (args.charAt(i)) {
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
          throw new IllegalArgumentException("Not valid");
      }
    }

    return !satisfied || testedDays <= 3;
  }
}