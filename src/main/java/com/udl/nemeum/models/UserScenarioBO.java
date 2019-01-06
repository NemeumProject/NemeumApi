package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_scenario", schema = "nemeum")
public class UserScenarioBO {

    private Integer userScenario;
    private IndividualUserBO userBO;
    private ScenarioBO scenarioBO;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateBooking;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date startScenario;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date endScenario;
    private Integer phone;
    private String email;
    private String customerName;

    public UserScenarioBO(Integer userScenario, IndividualUserBO userBO, ScenarioBO scenarioBO, Date dateBooking, Date startScenario, Date endScenario, Integer phone, String email, String customerName) {
        this.userScenario = userScenario;
        this.userBO = userBO;
        this.scenarioBO = scenarioBO;
        this.dateBooking = dateBooking;
        this.startScenario = startScenario;
        this.endScenario = endScenario;
        this.phone = phone;
        this.email = email;
        this.customerName = customerName;
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

    @Column(name = "date_booking")
    public Date getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(Date dateBooking) {
        this.dateBooking = dateBooking;
    }

    @Column(name = "start_scenario")
    public Date getStartScenario() {
        return startScenario;
    }

    public void setStartScenario(Date startScenario) {
        this.startScenario = startScenario;
    }

    @Column(name = "end_scenario")
    public Date getEndScenario() {
        return endScenario;
    }

    public void setEndScenario(Date endScenario) {
        this.endScenario = endScenario;
    }

    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name_customer")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

