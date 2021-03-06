package com.udl.nemeum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udl.nemeum.models.ScenarioBO;

import java.util.Date;

public class ScenarioDTO {

    private Integer idScenario;
    private Integer idSport;
    private Double price;
    private Boolean isIndoor;
    private Integer capacity;
    private Integer idCompany;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateScenario;
    private String description;
    private String title;
    private String image;
    private String address;
    private String city;

    public ScenarioDTO(ScenarioBO bo) {
        this.idScenario = bo.getIdScenario();
        this.idSport = bo.getIdSport().getIdSport();
        this.price = bo.getPrice();
        this.isIndoor = bo.getIndoor();
        this.capacity = bo.getCapacity();
        this.idCompany = bo.getIdCompany().getIdCompanyUser();
        this.dateScenario = bo.getDateScenario();
        this.description = bo.getDescription();
        this.title = bo.getTitle();
        this.image = bo.getImage();
        this.address = bo.getAddress();
        this.city = bo.getCity();
    }

    public ScenarioDTO(){
        super();
    }
    public Integer getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(Integer idScenario) {
        this.idScenario = idScenario;
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

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Date getDateScenario() {
        return dateScenario;
    }

    public void setDateScenario(Date dateScenario) {
        this.dateScenario = dateScenario;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
