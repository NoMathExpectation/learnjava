package nme.cs102.assignment1;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Time {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      LocalDateTime out = LocalDateTime.of(2022, 3, 14, sc.nextInt(), sc.nextInt(), sc.nextInt());
      LocalDateTime in = LocalDateTime.of(2022, 3, 14, sc.nextInt(), sc.nextInt(), sc.nextInt());

      Duration d = Duration.between(out, in);
      if (d.isNegative() || d.isZero()) {
        throw new DateTimeException("Not positive");
      }

      System.out.printf("%s%s%s", d.toHours() != 0 ? d.toHours() + "h" : "", d.toMinutes() != 0 ? d.toMinutes() % 60 + "m" : "", d.getSeconds() % 60 + "s");
    } catch (DateTimeException | NoSuchElementException e) {
      System.out.print("Not valid");
    }
  }
}