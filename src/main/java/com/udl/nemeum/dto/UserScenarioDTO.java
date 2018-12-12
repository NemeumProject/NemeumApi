package com.udl.nemeum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udl.nemeum.models.UserScenarioBO;

import java.util.Date;

public class UserScenarioDTO {

    private Integer userScenario;
    private Integer idUser;
    private Integer idScenario;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date startScenario;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date endScenario;

    public UserScenarioDTO(UserScenarioBO bo) {
        this.userScenario = bo.getUserScenario();
        this.idUser = bo.getUserBO().getIdIndividualUser();
        this.idScenario = bo.getScenarioBO().getIdScenario();
        this.dateBooking = bo.getDateBooking();
        this.startScenario = bo.getStartScenario();
        this.endScenario = bo.getEndScenario();
    }

    public UserScenarioDTO(){
        super();
    }

    public Integer getUserScenario() {
        return userScenario;
    }

    public void setUserScenario(Integer userScenario) {
        this.userScenario = userScenario;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(Integer idScenario) {
        this.idScenario = idScenario;
    }

    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }

    public Date getStartScenario() {
        return startScenario;
    }

    public void setStartScenario(Date startScenario) {
        this.startScenario = startScenario;
    }

    public Date getEndScenario() {
        return endScenario;
    }

    public void setEndScenario(Date endScenario) {
        this.endScenario = endScenario;
    }
}
