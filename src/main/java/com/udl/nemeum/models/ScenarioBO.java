package com.udl.nemeum.models;

import java.sql.Date;

public class ScenarioBO {

    private Long idScenario;
    private SportBO idSport;
    private Double price;
    private Boolean isIndoor;
    private Integer capacity;
    private CompanyUserBO idCompany;
    private Date dateScenario;

    public ScenarioBO(Long idScenario, SportBO idSport, Double price, Boolean isIndoor, Integer capacity, CompanyUserBO idCompany, Date dateScenario) {
        this.idScenario = idScenario;
        this.idSport = idSport;
        this.price = price;
        this.isIndoor = isIndoor;
        this.capacity = capacity;
        this.idCompany = idCompany;
        this.dateScenario = dateScenario;
    }

    public ScenarioBO(){
        super();
    }

    public Long getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(Long idScenario) {
        this.idScenario = idScenario;
    }

    public SportBO getIdSport() {
        return idSport;
    }

    public void setIdSport(SportBO idSport) {
        this.idSport = idSport;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public CompanyUserBO getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(CompanyUserBO idCompany) {
        this.idCompany = idCompany;
    }

    public Date getDateScenario() {
        return dateScenario;
    }

    public void setDateScenario(Date dateScenario) {
        this.dateScenario = dateScenario;
    }
}
