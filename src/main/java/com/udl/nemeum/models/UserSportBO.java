package com.udl.nemeum.models;

import javax.persistence.*;

@Entity
@Table(name = "user_sport")
public class UserSportBO {

    private Integer idUserSport;
    private IndividualUserBO userLevel;
    private SportBO sportLevel;
    private String level;


    public UserSportBO(Integer idUserSport, IndividualUserBO userLevel, SportBO sportLevel, String level) {
        this.idUserSport = idUserSport;
        this.userLevel = userLevel;
        this.sportLevel = sportLevel;
        this.level = level;
    }

    public UserSportBO(){
        super();
    }

    @Id
    @Column(name = "id_user_sport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUserSport() {
        return idUserSport;
    }

    public void setIdUserSport(Integer idUserSport) {
        this.idUserSport = idUserSport;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(IndividualUserBO userLevel) {
        this.userLevel = userLevel;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sport", referencedColumnName = "id_sport")
    public SportBO getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(SportBO sportLevel) {
        this.sportLevel = sportLevel;
    }

    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
