package com.rkasibha.springbootdemo.dto;

public class AddressDto {

    private String city;
    private String country;

    public AddressDto(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
