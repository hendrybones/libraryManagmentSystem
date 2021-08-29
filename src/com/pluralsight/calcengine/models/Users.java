package com.pluralsight.calcengine.models;

public class Users {
    String userId;
    String name;
    String email;
    String regDate;

//    public Users(String userId, String name, String email, String regDate) {
//        this.userId = userId;
//        this.name = name;
//        this.email = email;
//        this.regDate = regDate;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
