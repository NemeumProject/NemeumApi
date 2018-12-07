package com.udl.nemeum.dto;


import com.udl.nemeum.models.TrainerSportBO;

public class TrainerSportDTO {

    private Integer idTrainerSport;
    private Integer idTrainer;
    private Integer idSport;
    private String experience;

    public TrainerSportDTO(TrainerSportBO bo) {
        this.idTrainerSport = bo.getIdTrainerSport();
        this.idTrainer = bo.getTrainer().getIdTrainerUser();
        this.idSport = bo.getSportTrainer().getIdSport();
        this.experience = bo.getExperience();
    }

    public TrainerSportDTO(){
        super();
    }

    public Integer getIdTrainerSport() {
        return idTrainerSport;
    }

    public void setIdTrainerSport(Integer idTrainerSport) {
        this.idTrainerSport = idTrainerSport;
    }

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
