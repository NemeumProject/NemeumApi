package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sport")
public class SportBO {

    private Integer idSport;
    private String name;
    private List<ScenarioBO> scenarios = new ArrayList<>();
    private List<TeamBO> teams = new ArrayList<>();
    private List<UserSportBO> users = new ArrayList<>();
    private List<TrainerSportBO> trainers = new ArrayList<>();
    private List<EventBO> events = new ArrayList<>();

    public SportBO(Integer idSport, String name, List<ScenarioBO> scenarios, List<TeamBO> teams, List<UserSportBO> users, List<TrainerSportBO> trainers, List<EventBO> events) {
        this.idSport = idSport;
        this.name = name;
        this.scenarios = scenarios;
        this.teams = teams;
        this.users = users;
        this.trainers = trainers;
        this.events = events;
    }

    public SportBO(){
        super();
    }

    @Id
    @Column(name = "id_sport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    @Column(name = "name_sport")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "idSport", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<ScenarioBO> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioBO> scenarios) {
        this.scenarios = scenarios;
    }

    @OneToMany(mappedBy = "sport", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TeamBO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBO> teams) {
        this.teams = teams;
    }

    @OneToMany(mappedBy = "sportLevel", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<UserSportBO> getUsers() {
        return users;
    }

    public void setUsers(List<UserSportBO> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "id_sport_training_type", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TrainerSportBO> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<TrainerSportBO> trainers) {
        this.trainers = trainers;
    }

    @OneToMany(mappedBy = "sport", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<EventBO> getEvents() {
        return events;
    }

    public void setEvents(List<EventBO> events) {
        this.events = events;
    }
}
