package com.udl.nemeum.dto;

public class FilterTrainerServiceDTO {

    private String name;
    private String city;
    private Double price;
    private Integer sport_id;

    public FilterTrainerServiceDTO(String name, String city, Double price, Integer sport_id) {
        this.name = name;
        this.city = city;
        this.price = price;
        this.sport_id = sport_id;
    }

    public FilterTrainerServiceDTO(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSport_id() {
        return sport_id;
    }

    public void setSport_id(Integer sport_id) {
        this.sport_id = sport_id;
    }
}
