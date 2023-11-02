package com.HelloUser.HelloUser;

public class Members {

    private String fName;
    private String lName;
    private String email;
    private String stad;
    private int id;

    Members(String fName, String lName, String email, String stad, int id){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.stad = stad;
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}