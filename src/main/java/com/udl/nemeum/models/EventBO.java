package com.udl.nemeum.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event", schema = "nemeum")
public class EventBO {

    private Integer idEvent;
    private CompanyUserBO companyUser;
    private IndividualUserBO individualUser;
    private TrainerUserBO trainerUser;
    private SportBO sport;
    private Boolean isIndoor;
    private Integer capacity;
    private Double price;
    private String city;
    private String address;
    private String postalCode;
    private Integer phone;
    private Date dateEvent;
    private String description;

    public EventBO(Integer idEvent, CompanyUserBO companyUser, IndividualUserBO individualUser, TrainerUserBO trainerUser, SportBO sport, Boolean isIndoor, Integer capacity, Double price, String city, String address, String postalCode, Integer phone, Date dateEvent, String description) {
        this.idEvent = idEvent;
        this.companyUser = companyUser;
        this.individualUser = individualUser;
        this.trainerUser = trainerUser;
        this.sport = sport;
        this.isIndoor = isIndoor;
        this.capacity = capacity;
        this.price = price;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.dateEvent = dateEvent;
        this.description = description;
    }

    public EventBO(){
        super();
    }

    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    public CompanyUserBO getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUserBO companyUser) {
        this.companyUser = companyUser;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getIndividualUser() {
        return individualUser;
    }

    public void setIndividualUser(IndividualUserBO individualUser) {
        this.individualUser = individualUser;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_trainer")
    public TrainerUserBO getTrainerUser() {
        return trainerUser;
    }

    public void setTrainerUser(TrainerUserBO trainerUser) {
        this.trainerUser = trainerUser;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sport", referencedColumnName = "id_sport")
    public SportBO getSport() {
        return sport;
    }

    public void setSport(SportBO sport) {
        this.sport = sport;
    }

    @Column(name = "isindoor")
    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Column(name = "date_event")
    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
