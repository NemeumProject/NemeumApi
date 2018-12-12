package com.udl.nemeum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udl.nemeum.models.EventBO;

import java.util.Date;

public class EventDTO {

    private Integer idEvent;
    private Integer idCompanyUser;
    private Integer idSport;
    private Boolean indoor;
    private Integer capacity;
    private Double price;
    private String city;
    private String address;
    private String postalCode;
    private Integer phone;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateEvent;
    private String description;
    private String title;
    private String image;

    public EventDTO(EventBO bo) {
        this.idEvent = bo.getIdEvent();
        if(bo.getCompanyUser() != null){
            this.idCompanyUser = bo.getCompanyUser().getIdCompanyUser();
        }
        this.idSport = bo.getSport().getIdSport();
        this.indoor = bo.getIndoor();
        this.capacity = bo.getCapacity();
        this.price = bo.getPrice();
        this.city = bo.getCity();
        this.address = bo.getAddress();
        this.postalCode = bo.getPostalCode();
        this.phone = bo.getPhone();
        this.dateEvent = bo.getDateEvent();
        this.description = bo.getDescription();
        this.title = bo.getTitle();
        this.image = bo.getImage();
    }

    public EventDTO(){
        super();
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getIdCompanyUser() {
        return idCompanyUser;
    }

    public void setIdCompanyUser(Integer idCompanyUser) {
        this.idCompanyUser = idCompanyUser;
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
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
}
