package nme.cs102.lab4;

public class DaysOfYearMonth {
  public static void main(String[] args) {
    int year = Integer.parseInt(args[0]);
    int month = Integer.parseInt(args[1]);
    String monthName;
    int days = 0;
    switch (month) {
      case 1:
        monthName = "January";
        break;
      case 2:
        monthName = "February";
        break;
      case 3:
        monthName = "March";
        break;
      case 4:
        monthName = "April";
        break;
      case 5:
        monthName = "May";
        break;
      case 6:
        monthName = "June";
        break;
      case 7:
        monthName = "July";
        break;
      case 8:
        monthName = "August";
        break;
      case 9:
        monthName = "September";
        break;
      case 10:
        monthName = "October";
        break;
      case 11:
        monthName = "November";
        break;
      case 12:
        monthName = "December";
        break;
      default:
        throw new IllegalArgumentException("Not a valid month!");
    }
    switch (month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        days = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        days = 30;
        break;
      case 2:
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
          days = 29;
        } else {
          days = 28;
        }
        break;
      default:
    }
    System.out.printf("%s of %d has %d days.", monthName, year, days);
  }
}
