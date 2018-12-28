package com.udl.nemeum.dto;

public class FilterScenarioDTO {

    private Integer idSport;
    private Double price;
    private String city;

    public FilterScenarioDTO(Integer idSport, Double price, String city) {
        this.idSport = idSport;
        this.price = price;
        this.city = city;
    }

    public FilterScenarioDTO(){
        super();
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
