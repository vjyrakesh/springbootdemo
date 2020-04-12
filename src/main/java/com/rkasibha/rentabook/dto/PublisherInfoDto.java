package com.rkasibha.rentabook.dto;

public class PublisherInfoDto {

    private String name;
    private String format;

    public PublisherInfoDto() {
    }

    public PublisherInfoDto(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
