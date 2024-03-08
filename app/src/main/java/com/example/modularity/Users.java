package com.example.modularity;

public class Users {
    private String fullName,userName,password;

    public Users() {
        //default constructor is required for firebase
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Users(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
