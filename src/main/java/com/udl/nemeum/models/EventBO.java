package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
public class EventBO {

    private Integer idEvent;
    private CompanyUserBO companyUser;
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
    private String title;
    private String image;
    private List<TrainerEventBO> trainerEvent;
    private List<IndividualEventBO> individualEvent;

    public EventBO(Integer idEvent, CompanyUserBO companyUser, SportBO sport, Boolean isIndoor, Integer capacity, Double price, String city, String address, String postalCode, Integer phone, Date dateEvent, String description, String title, String image, List<TrainerEventBO> trainerEvent, List<IndividualEventBO> individualEvent) {
        this.idEvent = idEvent;
        this.companyUser = companyUser;
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
        this.title = title;
        this.image = image;
        this.trainerEvent = trainerEvent;
        this.individualEvent = individualEvent;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "event", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TrainerEventBO> getTrainerEvent() {
        return trainerEvent;
    }

    public void setTrainerEvent(List<TrainerEventBO> trainerEvent) {
        this.trainerEvent = trainerEvent;
    }

    @OneToMany(mappedBy = "eventIndividual", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<IndividualEventBO> getIndividualEvent() {
        return individualEvent;
    }

    public void setIndividualEvent(List<IndividualEventBO> individualEvent) {
        this.individualEvent = individualEvent;
    }
}
