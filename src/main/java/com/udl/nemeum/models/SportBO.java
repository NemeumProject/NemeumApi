package com.udl.nemeum.models;

public class SportBO {

    private Long idSport;
    private String name;
    private Integer maxPlayers;
    private Boolean isIndoor;

    public SportBO(Long idSport, String name, Integer maxPlayers, Boolean isIndoor) {
        this.idSport = idSport;
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.isIndoor = isIndoor;
    }

    public SportBO(){
        super();
    }

    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
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

    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }
}
