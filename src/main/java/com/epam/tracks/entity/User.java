package com.epam.tracks.entity;


import com.epam.tracks.entity.api.Identifible;
import com.epam.tracks.entity.api.Role;

public class User implements Identifible {

    private int userId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String dateOfBirth;
    private Role role;
    private String region;
    private String phoneNumber;
    private int bonusPoints;
    private int orderNumber;
    private String locale;

    private User(Builder builder){
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.login = builder.login;
        this.password = builder.password;
        this.dateOfBirth = builder.dateOfBirth;
        this.role = builder.role;
        this.region = builder.region;
        this.phoneNumber = builder.phoneNumber;
        this.bonusPoints = builder.bonusPoints;
        this.orderNumber = builder.orderNumber;
        this.locale = builder.locale;
    }


    public static class Builder{

        private int userId;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private String dateOfBirth;
        private Role role;
        private String region;
        private String phoneNumber;
        private int bonusPoints;
        private int orderNumber;
        private String locale;

        public Builder(Role role, int userId){
            this.userId = userId;
            this.role = role;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setLogin(String login){
            this.login = login;
            return this;
        }

        public Builder setPassword(String password){
            this.password = password;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setRegion(String region){
            this.region = region;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setBonudePoints(int bonusePoints){
            this.bonusPoints = bonusePoints;
            return this;
        }

        public Builder setOrderNumber(int orderNumber){
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setLocale(String locale){
            this.locale = locale;
            return this;
        }

        public User build(){
            return new User(this);
        }



    }

    public String getLogin(){
        return this.login;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Role getRole() {
        return role;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public String getLocale(){
        return locale;
    }



}
