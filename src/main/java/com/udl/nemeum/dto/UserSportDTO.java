package com.udl.nemeum.dto;

import com.udl.nemeum.models.UserSportBO;

public class UserSportDTO {

    private Integer idUserSport;
    private Integer idUser;
    private Integer idSport;
    private String level;

    public UserSportDTO(UserSportBO bo) {
        this.idUserSport = bo.getIdUserSport();
        this.idUser = bo.getUserLevel().getIdIndividualUser();
        this.idSport = bo.getSportLevel().getIdSport();
        this.level = bo.getLevel();
    }

    public UserSportDTO(){
        super();
    }
    public Integer getIdUserSport() {
        return idUserSport;
    }

    public void setIdUserSport(Integer idUserSport) {
        this.idUserSport = idUserSport;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdSport() {
        return idSport;
    }

    public void setIdSport(Integer idSport) {
        this.idSport = idSport;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
