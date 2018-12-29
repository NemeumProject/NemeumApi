package com.udl.nemeum.dto;

public class FilterScenarioByFacilityDTO {

    private Integer idSport;
    private Double price;
    private String city;
    private Integer idCompany;

    public FilterScenarioByFacilityDTO(Integer idSport, Double price, String city, Integer idCompany) {
        this.idSport = idSport;
        this.price = price;
        this.city = city;
        this.idCompany = idCompany;
    }

    public FilterScenarioByFacilityDTO(){
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

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }
}
