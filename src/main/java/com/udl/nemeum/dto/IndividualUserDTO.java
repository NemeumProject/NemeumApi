package com.udl.nemeum.dto;

import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.UserScenarioBO;

import java.util.ArrayList;
import java.util.List;

public class IndividualUserDTO {

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
    private String description;
    private String title;
    private String image;

    public IndividualUserDTO(IndividualUserBO bo) {
        this.idIndividualUser = bo.getIdIndividualUser();
        this.username = bo.getUsername();
        this.password = bo.getPassword();
        this.isPremium = bo.getPremium();
        this.firstName = bo.getFirstName();
        this.middleSurname = bo.getMiddleSurname();
        this.lastSurname = bo.getLastSurname();
        this.ssn = bo.getSsn();
        this.email = bo.getEmail();
        this.freeTraining = bo.getFreeTraining();
        this.freeFacility = bo.getFreeFacility();
        this.rentedHours = bo.getRentedHours();
        this.trainedHours = bo.getTrainedHours();
        this.city = bo.getCity();
        this.address = bo.getAddress();
        this.postalCode = bo.getPostalCode();
        this.phone = bo.getPhone();
        this.description = bo.getDescription();
        this.title = bo.getTitle();
        this.image = bo.getImage();
    }

    public IndividualUserDTO(){
        super();
    }

    public Integer getIdIndividualUser() {
        return idIndividualUser;
    }

    public void setIdIndividualUser(Integer idIndividualUser) {
        this.idIndividualUser = idIndividualUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleSurname() {
        return middleSurname;
    }

    public void setMiddleSurname(String middleSurname) {
        this.middleSurname = middleSurname;
    }

    public String getLastSurname() {
        return lastSurname;
    }

    public void setLastSurname(String lastSurname) {
        this.lastSurname = lastSurname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFreeTraining() {
        return freeTraining;
    }

    public void setFreeTraining(Boolean freeTraining) {
        this.freeTraining = freeTraining;
    }

    public Boolean getFreeFacility() {
        return freeFacility;
    }

    public void setFreeFacility(Boolean freeFacility) {
        this.freeFacility = freeFacility;
    }

    public Integer getRentedHours() {
        return rentedHours;
    }

    public void setRentedHours(Integer rentedHours) {
        this.rentedHours = rentedHours;
    }

    public Integer getTrainedHours() {
        return trainedHours;
    }

    public void setTrainedHours(Integer trainedHours) {
        this.trainedHours = trainedHours;
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
