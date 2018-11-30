package com.udl.nemeum.dto;

import com.udl.nemeum.models.UserScenarioBO;

public class UserScenarioDTO {

    private Integer userScenario;
    private Integer idUser;
    private Integer idScenario;

    public UserScenarioDTO(UserScenarioBO bo) {
        this.userScenario = bo.getUserScenario();
        this.idUser = bo.getUserBO().getIdIndividualUser();
        this.idScenario = bo.getScenarioBO().getIdScenario();
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
}
