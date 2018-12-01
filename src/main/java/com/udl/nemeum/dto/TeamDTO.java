package com.udl.nemeum.dto;

import com.udl.nemeum.models.TeamBO;

public class TeamDTO {

    private Integer idTeam;
    private Integer idSport;
    private String nameTeam;

    public TeamDTO(TeamBO bo) {
        this.idTeam = bo.getIdTeam();
        this.idSport = bo.getSport().getIdSport();
        this.nameTeam = bo.getNameTeam();
    }

    public TeamDTO(){
        super();
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
