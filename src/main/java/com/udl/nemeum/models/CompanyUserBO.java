package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companyuser", schema = "nemeum")
public class CompanyUserBO {

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
    private List<ScenarioBO> scenarios = new ArrayList<>();
    private List<EventBO> events = new ArrayList<>();

    public CompanyUserBO(Integer idCompanyUser, String username, String password, Boolean isPremium, String comercialName, String companyName, String contactPerson, String ssn, String email, String city, String address, String postalCode, Integer phone, List<ScenarioBO> scenarios, List<EventBO> events) {
        this.idCompanyUser = idCompanyUser;
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
        this.comercialName = comercialName;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.ssn = ssn;
        this.email = email;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.scenarios = scenarios;
        this.events = events;
    }

    public CompanyUserBO(){
        super();
    }

    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdCompanyUser() {
        return idCompanyUser;
    }

    public void setIdCompanyUser(Integer idCompanyUser) {
        this.idCompanyUser = idCompanyUser;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

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

    @Column(name = "comercial_name")
    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "contact_person")
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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

    @OneToMany(mappedBy = "idCompany", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<ScenarioBO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioBO> scenarios) {
        this.scenarios = scenarios;
    }

    @OneToMany(mappedBy = "companyUser", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<EventBO> getEvents() {
        return events;
    }

    public void setEvents(List<EventBO> events) {
        this.events = events;
    }
}
