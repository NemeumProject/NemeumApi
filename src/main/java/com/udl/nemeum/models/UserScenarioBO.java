package com.udl.nemeum.models;

import javax.persistence.*;

@Entity
@Table(name = "user_scenario", schema = "nemeum")
public class UserScenarioBO {

    private Integer userScenario;
    private IndividualUserBO userBO;
    private ScenarioBO scenarioBO;

    public UserScenarioBO(Integer userScenario, IndividualUserBO userBO, ScenarioBO scenarioBO) {
        this.userScenario = userScenario;
        this.userBO = userBO;
        this.scenarioBO = scenarioBO;
    }

    public UserScenarioBO(){
        super();
    }

    @Id
    @Column(name = "id_user_scenario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserScenario() {
        return userScenario;
    }

    public void setUserScenario(Integer userScenario) {
        this.userScenario = userScenario;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public IndividualUserBO getUserBO() {
        return userBO;
    }

    public void setUserBO(IndividualUserBO userBO) {
        this.userBO = userBO;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_scenario", referencedColumnName = "id_scenario")
    public ScenarioBO getScenarioBO() {
        return scenarioBO;
    }

    public void setScenarioBO(ScenarioBO scenarioBO) {
        this.scenarioBO = scenarioBO;
    }
}
