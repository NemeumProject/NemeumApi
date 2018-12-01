package com.udl.nemeum.dto;

import com.udl.nemeum.models.TeamUserBO;

public class TeamUserDTO {

    private Integer idTeamUser;
    private Integer idUser;
    private Integer idTeam;

    public TeamUserDTO(TeamUserBO bo) {
        this.idTeamUser = bo.getIdTeamUser();
        this.idUser = bo.getUser().getIdIndividualUser();
        this.idTeam = bo.getTeam().getIdTeam();
    }

    public TeamUserDTO(){
        super();
    }

    public Integer getIdTeamUser() {
        return idTeamUser;
    }

    public void setIdTeamUser(Integer idTeamUser) {
        this.idTeamUser = idTeamUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }
}
