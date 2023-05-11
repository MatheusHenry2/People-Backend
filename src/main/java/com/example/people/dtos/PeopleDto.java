package com.example.people.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PeopleDto {

    @NotBlank
    private String peopleName;

    @NotBlank
    @Email
    private String peopleEmail;

    @NotBlank
    private String peoplePassword;

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleEmail() {
        return peopleEmail;
    }

    public void setPeopleEmail(String peopleEmail) {
        this.peopleEmail = peopleEmail;
    }

    public String getPeoplePassword() {
        return peoplePassword;
    }

    public void setPeoplePassword(String peoplePassword) {
        this.peoplePassword = peoplePassword;
    }
}
