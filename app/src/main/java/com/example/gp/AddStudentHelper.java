package com.example.gp;

public class AddStudentHelper {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public AddStudentHelper() {
    }

    String name;
    String id;
    String email;

    public AddStudentHelper(String name, String id, String email, String password, String years) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.years = years;
    }

    String password;
    String years;
}
