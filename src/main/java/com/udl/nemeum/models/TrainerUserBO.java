package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "traineruser", schema = "nemeum")
public class TrainerUserBO {

    private Integer idTrainerUser;
    private String username;
    private String password;
    private Boolean isPremium;
    private String firstName;
    private String middleSurname;
    private String lastSurname;
    private String ssn;
    private String email;
    private Integer teachedHours;
    private String city;
    private String address;
    private String postalCode;
    private Integer phone;
    private String description;
    private String title;
    private String image;
    private List<TrainerSportBO> trainerSportBOList = new ArrayList<>();
    private List<TrainerEventBO> trainerEventBOList = new ArrayList<>();

    public TrainerUserBO(Integer idTrainerUser, String username, String password, Boolean isPremium, String firstName, String middleSurname, String lastSurname, String ssn, String email, Integer teachedHours, String city, String address, String postalCode, Integer phone, String description, String title, String image, List<TrainerSportBO> trainerSportBOList, List<TrainerEventBO> trainerEventBOList) {
        this.idTrainerUser = idTrainerUser;
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
        this.firstName = firstName;
        this.middleSurname = middleSurname;
        this.lastSurname = lastSurname;
        this.ssn = ssn;
        this.email = email;
        this.teachedHours = teachedHours;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.description = description;
        this.title = title;
        this.image = image;
        this.trainerSportBOList = trainerSportBOList;
        this.trainerEventBOList = trainerEventBOList;
    }

    public TrainerUserBO(){
        super();
    }

    @Id
    @Column(name = "id_trainer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTrainerUser() {
        return idTrainerUser;
    }

    public void setIdTrainerUser(Integer idTrainerUser) {
        this.idTrainerUser = idTrainerUser;
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

    @Column(name = "teached_hours")
    public Integer getTeachedHours() {
        return teachedHours;
    }

    public void setTeachedHours(Integer teachedHours) {
        this.teachedHours = teachedHours;
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

    @OneToMany(mappedBy = "id_trainer_user", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TrainerSportBO> getTrainerSportBOList() {
        return trainerSportBOList;
    }

    public void setTrainerSportBOList(List<TrainerSportBO> trainerSportBOList) {
        this.trainerSportBOList = trainerSportBOList;
    }

    @OneToMany(mappedBy = "trainerEvent", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TrainerEventBO> getTrainerEventBOList() {
        return trainerEventBOList;
    }

    public void setTrainerEventBOList(List<TrainerEventBO> trainerEventBOList) {
        this.trainerEventBOList = trainerEventBOList;
    }
}
