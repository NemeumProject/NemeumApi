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
    private Integer phone;
    private String email;

    public UserScenarioDTO(UserScenarioBO bo) {
        this.userScenario = bo.getUserScenario();
        if(bo.getUserBO() != null && bo.getUserBO().getIdIndividualUser() != null){
            this.idUser = bo.getUserBO().getIdIndividualUser();
        }
        this.idScenario = bo.getScenarioBO().getIdScenario();
        this.dateBooking = bo.getDateBooking();
        this.startScenario = bo.getStartScenario();
        this.endScenario = bo.getEndScenario();
        this.phone = bo.getPhone();
        this.email = bo.getEmail();
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
