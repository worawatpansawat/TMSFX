package com.tms.models;

import java.time.LocalDate;

public class User {

    private int Id;
    private String Username;
    private String PasswordHash;
    private String FullName;
    private String PrimaryAddress;
    private String PhoneNumber;
    private LocalDate StartDate;
    private Double SalaryAmount;
    private String UserType;

    public User() {

    }

    public User(int id, String username, String passwordHash, String fullName, String primaryAddress, String phoneNumber, LocalDate startDate, Double salaryAmount, String userType) {
        Id = id;
        Username = username;
        PasswordHash = passwordHash;
        FullName = fullName;
        PrimaryAddress = primaryAddress;
        PhoneNumber = phoneNumber;
        StartDate = startDate;
        SalaryAmount = salaryAmount;
        UserType = userType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPrimaryAddress() {
        return PrimaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        PrimaryAddress = primaryAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public Double getSalaryAmount() {
        return SalaryAmount;
    }

    public void setSalaryAmount(Double salaryAmount) {
        SalaryAmount = salaryAmount;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;

    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", PasswordHash='" + PasswordHash + '\'' +
                ", FullName='" + FullName + '\'' +
                ", PrimaryAddress='" + PrimaryAddress + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", StartDate=" + StartDate +
                ", SalaryAmount=" + SalaryAmount +
                ", UserType='" + UserType + '\'' +
                '}';
    }
}
