package com.udl.nemeum.models;

import javax.persistence.*;

@Entity
@Table(name = "trainer_sport", schema = "nemeum")
public class TrainerSportBO {

    private Integer idTrainerSport;
    private TrainerUserBO trainer;
    private SportBO sportTrainer;
    private String experience;

    public TrainerSportBO(Integer idTrainerSport, TrainerUserBO trainer, SportBO sportTrainer, String experience) {
        this.idTrainerSport = idTrainerSport;
        this.trainer = trainer;
        this.sportTrainer = sportTrainer;
        this.experience = experience;
    }

    public TrainerSportBO(){
        super();
    }

    @Id
    @Column(name = "id_trainer_sport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTrainerSport() {
        return idTrainerSport;
    }

    public void setIdTrainerSport(Integer idTrainerSport) {
        this.idTrainerSport = idTrainerSport;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_trainer")
    public TrainerUserBO getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerUserBO trainer) {
        this.trainer = trainer;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sport", referencedColumnName = "id_sport")
    public SportBO getSportTrainer() {
        return sportTrainer;
    }

    public void setSportTrainer(SportBO sportTrainer) {
        this.sportTrainer = sportTrainer;
    }

    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
