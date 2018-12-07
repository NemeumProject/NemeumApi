package com.udl.nemeum.dto;

import com.udl.nemeum.models.SportBO;

public class SportDTO {

    private Integer idSport;
    private String name;
    private Integer maxPlayers;
    private Boolean isTeamSport;

    public SportDTO(SportBO bo) {
        this.idSport = bo.getIdSport();
        this.name = bo.getName();
        this.maxPlayers = bo.getMaxPlayers();
        this.isTeamSport = bo.getTeamSport();
    }

    public SportDTO(){
        super();
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Boolean getTeamSport() {
        return isTeamSport;
    }

    public void setTeamSport(Boolean teamSport) {
        isTeamSport = teamSport;
    }
}
