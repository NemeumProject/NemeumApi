package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trainer_sport", schema = "nemeum")
public class TrainerSportBO {

    private Integer idTrainingServicePost;
    private TrainerUserBO id_trainer_user;
    private SportBO id_sport_training_type;
    private String training_address;
    private Double training_price;
    private String training_city;
    private Time training_start;
    private Time training_end;
    private String training_desc;
    private List<BookingTrainerBO> bookingTrainerBOList = new ArrayList<>();


    public TrainerSportBO(Integer idTrainingServicePost, TrainerUserBO id_trainer_user, SportBO id_sport_training_type, String training_address, Double training_price, String training_city, Time training_start, Time training_end, String training_desc, List<BookingTrainerBO> bookingTrainerBOList) {
        this.idTrainingServicePost = idTrainingServicePost;
        this.id_trainer_user = id_trainer_user;
        this.id_sport_training_type = id_sport_training_type;
        this.training_address = training_address;
        this.training_price = training_price;
        this.training_city = training_city;
        this.training_start = training_start;
        this.training_end = training_end;
        this.training_desc = training_desc;
        this.bookingTrainerBOList = bookingTrainerBOList;
    }

    public TrainerSportBO() {
        super();
    }

    @Id
    @Column(name = "id_training_service_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTrainingServicePost() {
        return idTrainingServicePost;
    }

    public void setIdTrainingServicePost(Integer idTrainingServicePost) {
        this.idTrainingServicePost = idTrainingServicePost;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_trainer_user", referencedColumnName = "id_trainer")
    public TrainerUserBO getId_trainer_user() {
        return id_trainer_user;
    }


    public void setId_trainer_user(TrainerUserBO id_trainer_user) {
        this.id_trainer_user = id_trainer_user;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sport_training_type", referencedColumnName = "id_sport")
    public SportBO getId_sport_training_type() {
        return id_sport_training_type;
    }

    public void setId_sport_training_type(SportBO id_sport_training_type) {
        this.id_sport_training_type = id_sport_training_type;
    }

    @Column(name = "training_address")
    public String getTraining_address() {
        return training_address;
    }

    public void setTraining_address(String training_address) {
        this.training_address = training_address;
    }

    @Column(name = "training_price")
    public Double getTraining_price() {
        return training_price;
    }

    public void setTraining_price(Double training_price) {
        this.training_price = training_price;
    }

    @Column(name = "training_city")
    public String getTraining_city() {
        return training_city;
    }

    public void setTraining_city(String training_city) {
        this.training_city = training_city;
    }

    @Column(name = "training_start")
    public Time getTraining_start() {
        return training_start;
    }

    public void setTraining_start(Time training_start) {
        this.training_start = training_start;
    }

    @Column(name = "training_end")
    public Time getTraining_end() {
        return training_end;
    }

    public void setTraining_end(Time training_end) {
        this.training_end = training_end;
    }

    @Column(name = "training_desc")
    public String getTraining_desc() {
        return training_desc;
    }

    public void setTraining_desc(String training_desc) {
        this.training_desc = training_desc;
    }

    @OneToMany(mappedBy = "idService", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<BookingTrainerBO> getBookingTrainerBOList() {
        return bookingTrainerBOList;
    }

    public void setBookingTrainerBOList(List<BookingTrainerBO> bookingTrainerBOList) {
        this.bookingTrainerBOList = bookingTrainerBOList;
    }
}