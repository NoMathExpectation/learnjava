package nme.cs102.lab14;

public class Student {
  private final String firstName;
  private final String lastName;
  private final Gender gender;

  public Student(String firstName, String lastName, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
  }

  public String toString() {
    return String.format("%s %s, %s", firstName, lastName, gender);
  }
}

enum Gender {MALE, FEMALE}
