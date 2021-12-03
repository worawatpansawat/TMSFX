package com.tms.enumurator;

public class UserType {
    public static final String None = "";
    public static final String User = "User";
    public static final String Admin = "Admin";
    public static final String System = "System";

    private String text;

    public UserType() {

    }

    public UserType(String s) {
        this.text = s.toString();
    }

    public String getValue(){
        return this.text;
    }

}
