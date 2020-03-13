package com.rkasibha.springbootdemo.dto;

public class AuthorDto {

    private String firstName;
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
