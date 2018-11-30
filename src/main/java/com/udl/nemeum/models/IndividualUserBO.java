package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "individualuser", schema = "nemeum")
public class IndividualUserBO {

    private Integer idIndividualUser;
    private String username;
    private String password;
    private Boolean isPremium;
    private String firstName;
    private String middleSurname;
    private String lastSurname;
    private String ssn;
    private String email;
    private Boolean freeTraining;
    private Boolean freeFacility;
    private Integer rentedHours;
    private Integer trainedHours;
    private String city;
    private String address;
    private String postalCode;
    private Integer phone;
    private List<UserScenarioBO> scenarios = new ArrayList<>();

    public IndividualUserBO(Integer idIndividualUser, String username, String password, Boolean isPremium, String firstName, String middleSurname, String lastSurname, String ssn, String email, Boolean freeTraining, Boolean freeFacility, Integer rentedHours, Integer trainedHours, String city, String address, String postalCode, Integer phone, List<UserScenarioBO> scenarios) {
        this.idIndividualUser = idIndividualUser;
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
        this.firstName = firstName;
        this.middleSurname = middleSurname;
        this.lastSurname = lastSurname;
        this.ssn = ssn;
        this.email = email;
        this.freeTraining = freeTraining;
        this.freeFacility = freeFacility;
        this.rentedHours = rentedHours;
        this.trainedHours = trainedHours;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.scenarios = scenarios;
    }

    public IndividualUserBO(){
        super();
    }

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdIndividualUser() {
        return idIndividualUser;
    }

    public void setIdIndividualUser(Integer idIndividualUser) {
        this.idIndividualUser = idIndividualUser;
    }
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ispremium")
    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_surname_initial")
    public String getMiddleSurname() {
        return middleSurname;
    }

    public void setMiddleSurname(String middleSurname) {
        this.middleSurname = middleSurname;
    }

    @Column(name = "last_surname")
    public String getLastSurname() {
        return lastSurname;
    }

    public void setLastSurname(String lastSurname) {
        this.lastSurname = lastSurname;
    }

    @Column(name = "ssn")
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "free_training")
    public Boolean getFreeTraining() {
        return freeTraining;
    }

    public void setFreeTraining(Boolean freeTraining) {
        this.freeTraining = freeTraining;
    }

    @Column(name = "free_facility")
    public Boolean getFreeFacility() {
        return freeFacility;
    }

    public void setFreeFacility(Boolean freeFacility) {
        this.freeFacility = freeFacility;
    }

    @Column(name = "rented_hours")
    public Integer getRentedHours() {
        return rentedHours;
    }

    public void setRentedHours(Integer rentedHours) {
        this.rentedHours = rentedHours;
    }

    @Column(name = "trained_hours")
    public Integer getTrainedHours() {
        return trainedHours;
    }

    public void setTrainedHours(Integer trainedHours) {
        this.trainedHours = trainedHours;
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

    @OneToMany(mappedBy = "userBO", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<UserScenarioBO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<UserScenarioBO> scenarios) {
        this.scenarios = scenarios;
    }
}