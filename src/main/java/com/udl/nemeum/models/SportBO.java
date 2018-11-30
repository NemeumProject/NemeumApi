package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sport", schema = "nemeum")
public class SportBO {

    private Integer idSport;
    private String name;
    private Integer maxPlayers;
    private Boolean isTeamSport;
    private List<ScenarioBO> scenarios = new ArrayList<>();

    public SportBO(Integer idSport, String name, Integer maxPlayers, Boolean isTeamSport) {
        this.idSport = idSport;
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.isTeamSport = isTeamSport;
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

    @Column(name = "max_player")
    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Column(name="is_team_sport")
    public Boolean getTeamSport() {
        return isTeamSport;
    }

    public void setTeamSport(Boolean teamSport) {
        isTeamSport = teamSport;
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
}
