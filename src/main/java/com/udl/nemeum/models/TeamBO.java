package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamBO {

    private Integer idTeam;
    private SportBO sport;
    private String nameTeam;
    private List<TeamUserBO> teamUserBOList = new ArrayList<>();

    public TeamBO(Integer idTeam, SportBO sport, String nameTeam, List<TeamUserBO> teamUserBOList) {
        this.idTeam = idTeam;
        this.sport = sport;
        this.nameTeam = nameTeam;
        this.teamUserBOList = teamUserBOList;
    }

    public TeamBO(){
        super();
    }

    @Id
    @Column(name = "id_team")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sport_id", referencedColumnName = "id_sport")
    public SportBO getSport() {
        return sport;
    }

    public void setSport(SportBO sport) {
        this.sport = sport;
    }

    @Column(name = "name_team")
    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    @OneToMany(mappedBy = "team", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<TeamUserBO> getTeamUserBOList() {
        return teamUserBOList;
    }

    public void setTeamUserBOList(List<TeamUserBO> teamUserBOList) {
        this.teamUserBOList = teamUserBOList;
    }
}
