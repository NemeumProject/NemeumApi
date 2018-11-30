package com.udl.nemeum.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "scenario", schema = "nemeum")
public class ScenarioBO {

    private Integer idScenario;
    private SportBO idSport;
    private Double price;
    private Boolean isIndoor;
    private Integer capacity;
    private CompanyUserBO idCompany;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateScenario;
    private List<UserScenarioBO> userScenarioBOList;

    public ScenarioBO(Integer idScenario, SportBO idSport, Double price, Boolean isIndoor, Integer capacity, CompanyUserBO idCompany, Date dateScenario, List<UserScenarioBO> userScenarioBOList) {
        this.idScenario = idScenario;
        this.idSport = idSport;
        this.price = price;
        this.isIndoor = isIndoor;
        this.capacity = capacity;
        this.idCompany = idCompany;
        this.dateScenario = dateScenario;
        this.userScenarioBOList = userScenarioBOList;
    }

    public ScenarioBO(){
        super();
    }

    @Id
    @Column(name = "id_scenario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdScenario() {
        return idScenario;
    }

    public void setIdScenario(Integer idScenario) {
        this.idScenario = idScenario;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sport_id", referencedColumnName = "id_sport")
    public SportBO getIdSport() {
        return idSport;
    }

    public void setIdSport(SportBO idSport) {
        this.idSport = idSport;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "isindoor")
    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id", referencedColumnName = "id_company")
    public CompanyUserBO getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(CompanyUserBO idCompany) {
        this.idCompany = idCompany;
    }

    @Column(name = "date_scenario")
    public Date getDateScenario() {
        return dateScenario;
    }

    public void setDateScenario(Date dateScenario) {
        this.dateScenario = dateScenario;
    }

    @OneToMany(mappedBy = "scenarioBO", cascade=CascadeType.PERSIST)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    public List<UserScenarioBO> getUserScenarioBOList() {
        return userScenarioBOList;
    }

    public void setUserScenarioBOList(List<UserScenarioBO> userScenarioBOList) {
        this.userScenarioBOList = userScenarioBOList;
    }
}
