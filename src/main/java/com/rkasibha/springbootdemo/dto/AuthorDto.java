package com.rkasibha.springbootdemo.dto;

import com.rkasibha.springbootdemo.annotation.CustomNameConstraint;

import javax.validation.constraints.NotBlank;

public class AuthorDto {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @CustomNameConstraint
    private String lastName;
    private AddressDto address;

    public AuthorDto() {}

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
