package models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class User {
    private int id;
    private String name;
    private String email;
    private int idCountry;

    public User() {
    }

    public User(int id, String name, String email, int idCountry) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idCountry = idCountry;
    }

    public User(String name, String email, int idCountry) {
        this.name = name;
        this.email = email;
        this.idCountry = idCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }
}
