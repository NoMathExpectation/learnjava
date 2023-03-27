package nme.cs102.assignment3.pokemon;

public class Skill {
  private String name;
  private int cd;
  private int atk;

  public Skill(String name, int cd, int atk) {
    if (name == null || cd <= 0 || atk <= 0) {
      this.name = "error";
      this.cd = 51;
      this.atk = 0;
      return;
    }

    this.name = name;
    this.cd = cd;
    this.atk = atk;
  }


  public String getSkillName() {
    return name;
  }

  public int getSkillCd() {
    return cd;
  }

  public int getSkillAtk() {
    return atk;
  }
}
