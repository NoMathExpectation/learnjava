package nme.cs209a.assignment1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

class Course {
  public final String institution;
  public final String number;
  public final LocalDate launchDate;
  public final String title;
  public final Set<String> instructors;
  public final String subject;
  public final int year;
  public final int honorCode;
  public final int participants;
  public final int audited;
  public final int certified;
  public final double percentAudited;
  public final double percentCertified;
  public final double percentCertified50;
  public final double percentVideo;
  public final double percentForum;
  public final double gradeHigherZero;
  public final double totalHours;
  public final double medianHoursCertification;
  public final double medianAge;
  public final double percentMale;
  public final double percentFemale;
  public final double percentDegree;

  public Course(String institution, String number, LocalDate launchDate,
                String title, String instructors, String subject,
                int year, int honorCode, int participants,
                int audited, int certified, double percentAudited,
                double percentCertified, double percentCertified50,
                double percentVideo, double percentForum, double gradeHigherZero,
                double totalHours, double medianHoursCertification,
                double medianAge, double percentMale, double percentFemale,
                double percentDegree) {
    this.institution = institution;
    this.number = number;
    this.launchDate = launchDate;
    if (title.startsWith("\"")) {
      title = title.substring(1);
    }
    if (title.endsWith("\"")) {
      title = title.substring(0, title.length() - 1);
    }
    this.title = title;
    if (instructors.startsWith("\"")) {
      instructors = instructors.substring(1);
    }
    if (instructors.endsWith("\"")) {
      instructors = instructors.substring(0, instructors.length() - 1);
    }
    this.instructors = Set.of(instructors.split(", "));
    if (subject.startsWith("\"")) {
      subject = subject.substring(1);
    }
    if (subject.endsWith("\"")) {
      subject = subject.substring(0, subject.length() - 1);
    }
    this.subject = subject;
    this.year = year;
    this.honorCode = honorCode;
    this.participants = participants;
    this.audited = audited;
    this.certified = certified;
    this.percentAudited = percentAudited;
    this.percentCertified = percentCertified;
    this.percentCertified50 = percentCertified50;
    this.percentVideo = percentVideo;
    this.percentForum = percentForum;
    this.gradeHigherZero = gradeHigherZero;
    this.totalHours = totalHours;
    this.medianHoursCertification = medianHoursCertification;
    this.medianAge = medianAge;
    this.percentMale = percentMale;
    this.percentFemale = percentFemale;
    this.percentDegree = percentDegree;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(title, course.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title);
  }
}
