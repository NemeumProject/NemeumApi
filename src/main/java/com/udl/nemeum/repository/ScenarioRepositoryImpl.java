package com.udl.nemeum.repository;

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
        String query = null;
        Integer sport_id = null;
        if(sport != null){
            sport_id = sport.getIdSport();
        }

        if(sport_id != null && price != null && city != null){
            query = "SELECT * FROM scenario WHERE sport_id = " + sport_id + " AND price <=" + price + " AND address LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price != null && city == null) {
            query = "SELECT * FROM scenario WHERE sport_id = " + sport_id + " AND price <=" + price + ";";
        }else if(sport_id != null && price == null && city != null){
            query = "SELECT * FROM scenario WHERE sport_id = " + sport_id + " AND address LIKE " + "'%" + city + "%';";
        }else if(sport_id != null && price == null && city == null){
            query = "SELECT * FROM scenario WHERE sport_id = " + sport_id + ";";
        }else if(sport_id == null && price != null && city != null){
            query = "SELECT * FROM scenario WHERE price <=" + price + " AND address LIKE " + "'%" + city + "%';";
        }else if(sport_id == null && price != null && city == null){
            query = "SELECT * FROM scenario WHERE  price <=" + price + ";";
        }else if(sport_id == null && price == null && city != null){
            query = "SELECT * FROM scenario WHERE address LIKE " + "'%" + city + "%';";
        }

        if(query == null){
            return new ArrayList<ScenarioBO>();
        }else{
            Query q = entityManager.createNativeQuery(query, ScenarioBO.class);

            return q.getResultList();
        }
    }
}
