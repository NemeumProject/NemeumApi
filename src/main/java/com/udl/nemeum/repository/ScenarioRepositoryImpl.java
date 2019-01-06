package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.models.SportBO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ScenarioRepositoryImpl implements ScenarioRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private ScenarioRepository scenarioRepository;

    @Override
    public List<ScenarioBO> findScenarioByFilter(SportBO sport, Double price, String city) {
        String query = "SELECT * FROM scenario ";
        Integer sport_id = null;
        if(sport != null){
            sport_id = sport.getIdSport();
        }

        if(sport_id != null && price != null && city != null){
            query += "WHERE sport_id = " + sport_id + " AND price <=" + price + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price != null && city == null) {
            query += "WHERE sport_id = " + sport_id + " AND price <=" + price + ";";
        }else if(sport_id != null && price == null && city != null){
            query += "WHERE sport_id = " + sport_id + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price == null && city == null){
            query += "WHERE sport_id = " + sport_id + ";";
        }else if(sport_id == null && price != null && city != null){
            query += "WHERE price <=" + price + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id == null && price != null && city == null){
            query += "WHERE  price <=" + price + ";";
        }else if(sport_id == null && price == null && city != null){
            query += "WHERE city LIKE " + "'%" + city + "%';";
        }
        Query q = entityManager.createNativeQuery(query, ScenarioBO.class);

        return q.getResultList();

    }

    @Override
    public List<ScenarioBO> findScenarioByFacilityFilter(SportBO sport, Double price, String city, CompanyUserBO user) {
        String query = null;
        Integer sport_id = null;
        Integer company_id = null;
        if(sport != null){
            sport_id = sport.getIdSport();
        }
        if(user != null){
            company_id = user.getIdCompanyUser();
        }

        if(sport_id != null && price != null && city != null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND sport_id = " + sport_id + " AND price <=" + price + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price != null && city == null) {
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND sport_id = " + sport_id + " AND price <=" + price + ";";
        }else if(sport_id != null && price == null && city != null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND sport_id = " + sport_id + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price == null && city == null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND sport_id = " + sport_id + ";";
        }else if(sport_id == null && price != null && city != null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND price <=" + price + " AND city LIKE " + "'%" + city + "%';";
        }else if(sport_id == null && price != null && city == null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND  price <=" + price + ";";
        }else if(sport_id == null && price == null && city != null){
            query = "SELECT * FROM scenario WHERE company_id = " + company_id + " AND city LIKE " + "'%" + city + "%';";
        }

        if(query == null){
            return new ArrayList<ScenarioBO>();
        }else{
            Query q = entityManager.createNativeQuery(query, ScenarioBO.class);

            return q.getResultList();
        }
    }
}
