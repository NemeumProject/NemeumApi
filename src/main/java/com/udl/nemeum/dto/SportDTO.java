package com.udl.nemeum.dto;

import com.udl.nemeum.models.SportBO;

public class SportDTO {

    private Integer idSport;
    private String name;

    public SportDTO(SportBO bo) {
        this.idSport = bo.getIdSport();
        this.name = bo.getName();
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
}
