package com.example.conke.avaluo;

/**
 * Created by conke on 17/03/2019.
 */

public class Client {

    private String name;
    private String number;
    private String email;

    public Client(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
