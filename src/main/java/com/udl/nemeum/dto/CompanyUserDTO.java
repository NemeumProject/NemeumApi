package com.udl.nemeum.dto;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.ScenarioBO;

import java.util.ArrayList;
import java.util.List;

public class CompanyUserDTO {

    private Integer idCompanyUser;
    private String username;
    private String password;
    private Boolean isPremium;
    private String comercialName;
    private String companyName;
    private String contactPerson;
    private String ssn;
    private String email;
    private String city;
    private String address;
    private String postalCode;
    private Integer phone;
    private String title;
    private String description;
    private String image;
    private List<ScenarioBO> scenarios = new ArrayList<>();

    public CompanyUserDTO(CompanyUserBO bo) {
        this.idCompanyUser = bo.getIdCompanyUser();
        this.username = bo.getUsername();
        this.password = bo.getPassword();
        this.isPremium = bo.getPremium();
        this.comercialName = bo.getComercialName();
        this.companyName = bo.getCompanyName();
        this.contactPerson = bo.getContactPerson();
        this.ssn = bo.getSsn();
        this.email = bo.getEmail();
        this.city = bo.getCity();
        this.address = bo.getAddress();
        this.postalCode = bo.getPostalCode();
        this.phone = bo.getPhone();
        this.title = bo.getTitle();
        this.description = bo.getDescription();
        this.image = bo.getImage();
        if(bo.getScenarios() != null){
            this.scenarios = bo.getScenarios();
        }

    }

    public CompanyUserDTO(){
        super();
    }

    public Integer getIdCompanyUser() {
        return idCompanyUser;
    }

    public void setIdCompanyUser(Integer idCompanyUser) {
        this.idCompanyUser = idCompanyUser;
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

    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ScenarioBO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioBO> scenarios) {
        this.scenarios = scenarios;
    }
}
