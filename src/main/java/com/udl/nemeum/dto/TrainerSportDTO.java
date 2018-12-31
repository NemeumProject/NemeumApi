package com.udl.nemeum.dto;

import com.udl.nemeum.models.TrainerSportBO;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

public class TrainerSportDTO {

    private Integer id_training_service_post;
    private Integer id_trainer_user;
    private Integer id_sport_training_type;
    private String training_address;
    private Double training_price;
    private String training_city;
    private Time training_start;
    private Time training_end;
    private String training_desc;

    public TrainerSportDTO() {
        super();

    }

    public TrainerSportDTO(TrainerSportBO BO) {
        this.id_training_service_post = BO.getIdTrainingServicePost();
        this.id_trainer_user = BO.getId_trainer_user().getIdTrainerUser();
        this.id_sport_training_type = BO.getId_sport_training_type().getIdSport();
        this.training_address = BO.getTraining_address();
        this.training_price = BO.getTraining_price();
        this.training_city = BO.getTraining_city();
        this.training_start = BO.getTraining_start();
        this.training_end = BO.getTraining_end();
        this.training_desc = BO.getTraining_desc();
    }

    public Integer getId_training_service_post() {
        return id_training_service_post;
    }

    public void setId_training_service_post(Integer id_training_service_post) {
        this.id_training_service_post = id_training_service_post;
    }

    public Integer getId_trainer_user() {
        return id_trainer_user;
    }

    public void setId_trainer_user(Integer id_trainer_user) {
        this.id_trainer_user = id_trainer_user;
    }

    public Integer getId_sport_training_type() {
        return id_sport_training_type;
    }

    public void setId_sport_training_type(Integer id_sport_training_type) {
        this.id_sport_training_type = id_sport_training_type;
    }

    public String getTraining_address() {
        return training_address;
    }

    public void setTraining_address(String training_address) {
        this.training_address = training_address;
    }

    public Double getTraining_price() {
        return training_price;
    }

    public void setTraining_price(Double training_price) {
        this.training_price = training_price;
    }

    public String getTraining_city() {
        return training_city;
    }

    public void setTraining_city(String training_city) {
        this.training_city = training_city;
    }

    public Time getTraining_start() {
        return training_start;
    }

    public void setTraining_start(Time training_start) {
        this.training_start = training_start;
    }

    public Time getTraining_end() {
        return training_end;
    }

    public void setTraining_end(Time training_end) {
        this.training_end = training_end;
    }

    public String getTraining_desc() {
        return training_desc;
    }

    public void setTraining_desc(String training_desc) {
        this.training_desc = training_desc;
    }
}