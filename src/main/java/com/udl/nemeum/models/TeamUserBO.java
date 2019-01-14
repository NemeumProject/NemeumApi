package com.udl.nemeum.models;

import javax.persistence.*;

@Entity
@Table(name = "team_individualuser")
public class TeamUserBO {

    private Integer idTeamUser;
    private IndividualUserBO user;
    private TeamBO team;

    public TeamUserBO(Integer idTeamUser, IndividualUserBO user, TeamBO team) {
        this.idTeamUser = idTeamUser;
        this.user = user;
        this.team = team;
    }

    public TeamUserBO() {
        super();
    }

    @Id
    @Column(name = "id_team_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTeamUser() {
        return idTeamUser;
    }

    public void setIdTeamUser(Integer idTeamUser) {
        this.idTeamUser = idTeamUser;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getUser() {
        return user;
    }

    public void setUser(IndividualUserBO user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_team", referencedColumnName = "id_team")
    public TeamBO getTeam() {
        return team;
    }

    public void setTeam(TeamBO team) {
        this.team = team;
    }
}
