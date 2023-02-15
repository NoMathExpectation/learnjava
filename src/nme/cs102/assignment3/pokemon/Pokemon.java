package nme.cs102.assignment3.pokemon;

public class Pokemon {
    private String name;


    private int hp;
    private int rateHp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }


    private int atk;
    private int rateAtk;

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }


    private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    private int level;

    public void levelUP(int up) {
        level += up;
        atk += up * rateAtk;
        hp += up * rateHp;
    }

    Skill skill;

    public void learnSkill(Skill skill) {
        this.skill = skill;
    }


    public Pokemon(String name, int hp, int atk, Skill skills, int level, int speed, int rateAtk, int rateHp) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        skill = skills;
        this.level = level;
        this.speed = speed;
        this.rateAtk = rateAtk;
        this.rateHp = rateHp;
    }
}
