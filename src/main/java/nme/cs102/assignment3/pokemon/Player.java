package nme.cs102.assignment3.pokemon;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Player {
    private final String account = generateAccount();
    private String password;
    private Mail mail;
    private PhoneNumber phoneNumber;
    ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Player(Mail mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Player(PhoneNumber phoneNumber,String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Player(Mail mail, PhoneNumber phoneNumber,String password) {
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public boolean checkIdentity(Mail mail, String password) {
        return Objects.equals(this.mail, mail) && Objects.equals(this.password, password);
    }

    public boolean checkIdentity(PhoneNumber phoneNumber, String password) {
        return Objects.equals(this.phoneNumber, phoneNumber) && Objects.equals(this.password, password);
    }

    public boolean setMail(PhoneNumber phoneNumber, String password, Mail mail) {
        if (checkIdentity(phoneNumber, password)) {
            this.mail = mail;
            return true;
        }
        return false;
    }

    public boolean setPhoneNumber(Mail mail, String password, PhoneNumber phoneNumber) {
        if (checkIdentity(mail, password)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        return false;
    }

    public String getAccount() {
        return account;
    }

    public Mail getMail() {
        return mail;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String generateAccount() {
        return String.valueOf(new Random().nextInt(8999999) + 1000000);
    }

    public boolean changePassword(PhoneNumber phoneNumber, String oldPassword, String newPassword) {
        if (checkIdentity(phoneNumber, oldPassword)) {
            password = newPassword;
            return true;
        }
        return false;
    }

    public boolean changePassword(Mail mail,String oldPassword, String newPassword) {
        if (checkIdentity(mail, oldPassword)) {
            password = newPassword;
            return true;
        }
        return false;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
}

class Mail {
    public String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object another) {
        return another instanceof Mail && Objects.equals(mail, ((Mail) another).mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}

class PhoneNumber {
    public String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object another) {
        return another instanceof PhoneNumber && Objects.equals(phoneNumber, ((PhoneNumber) another).phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
