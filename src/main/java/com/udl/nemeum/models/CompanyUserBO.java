package com.udl.nemeum.models;

public class CompanyUserBO {

    private Long idCompanyUser;
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
    private Integer number;

    public CompanyUserBO(Long idCompanyUser, String username, String password, Boolean isPremium, String comercialName, String companyName, String contactPerson, String ssn, String email, String city, String address, String postalCode, Integer number) {
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
        this.number = number;
    }

    public CompanyUserBO(){
        super();
    }

    public Long getIdCompanyUser() {
        return idCompanyUser;
    }

    public void setIdCompanyUser(Long idCompanyUser) {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
