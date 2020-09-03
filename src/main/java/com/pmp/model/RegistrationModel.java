package com.pmp.model;


import java.util.ArrayList;
import java.util.List;

public class RegistrationModel {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String address;
    private String city;
    private String state;
    private String nationality;
    private int age;
    private String username;
    private String password;
    private String confirmPassword;
    private String designation;

    static  List<String> compulsoryUserFields = new ArrayList<>();

    public List<String> validationFields(){

        compulsoryUserFields.add(username);
        compulsoryUserFields.add(password);
        compulsoryUserFields.add(confirmPassword);
        compulsoryUserFields.add(firstName);
        compulsoryUserFields.add(lastName);
        compulsoryUserFields.add(designation);
        compulsoryUserFields.add(email);
        compulsoryUserFields.add(phoneNo);
        return  compulsoryUserFields;
    }
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
