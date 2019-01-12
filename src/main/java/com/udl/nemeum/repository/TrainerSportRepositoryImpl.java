package com.udl.nemeum.repository;

import com.udl.nemeum.models.SportBO;
import com.udl.nemeum.models.TrainerSportBO;
import com.udl.nemeum.models.TrainerUserBO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TrainerSportRepositoryImpl implements TrainerSportRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    @Override
    public List<TrainerSportBO> filter(String nameTrainer, String city, Double price, Integer sport_id) {
        String query = null;
        TrainerUserBO trainer = null;
        if(nameTrainer != null){
            nameTrainer = nameTrainer.toLowerCase();
        }
        query = "SELECT service.* FROM trainer_sport service";

        if(nameTrainer != null && city != null && price != null && sport_id != null){
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%' AND service.training_city = '" + city + "' AND service.training_price <="  + price +
                    " AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer != null && city != null && price != null && sport_id == null) {
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%' AND service.training_city = '" + city + "' AND service.training_price <=" + price + ";";
        }else if(nameTrainer != null && city != null && price == null && sport_id != null) {
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%'  AND service.training_city = '" + city +
                    "' AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer != null && city == null && price != null && sport_id != null){
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%'  AND service.training_price <="  + price +
                    " AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer != null && city != null && price == null && sport_id == null){
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%'  AND service.training_city = '" + city + "';";
        }else if(nameTrainer != null && city == null && price == null && sport_id == null) {
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%';";
        }else if(nameTrainer != null && city == null && price != null && sport_id == null) {
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%' AND service.training_price <= " + price + ";";
        }else if(nameTrainer != null && city == null && price == null && sport_id != null){
            query += " INNER JOIN traineruser trainer on (service.id_trainer_user = trainer.id_trainer) WHERE lower (trainer.first_name) LIKE '%" + nameTrainer + "%' AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer == null && city != null && price != null && sport_id != null) {
            query += " WHERE service.training_city = '" + city + "' AND service.training_price <=" + price +
                    " AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer == null && city != null && price == null && sport_id != null){
            query += " WHERE service.training_city = '" + city + "' AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer == null && city != null && price != null && sport_id == null){
            query += " WHERE service.training_city = '" + city + "' AND service.training_price <="  + price +";";
        }else if(nameTrainer == null && city != null && price == null && sport_id == null){
            query += " WHERE service.training_city = '" + city + "';";
        }else if(nameTrainer == null && city == null && price != null && sport_id != null){
            query += " WHERE service.training_price <="  + price +
                    " AND service.id_sport_training_type = " + sport_id + ";";
        }else if(nameTrainer == null && city == null && price != null && sport_id == null){
            query += " WHERE service.training_price <="  + price + ";";
        }else if(nameTrainer == null && city == null && price == null && sport_id != null){
            query += " WHERE service.id_sport_training_type = " + sport_id + ";";
        }

        Query q = entityManager.createNativeQuery(query, TrainerSportBO.class);

        return q.getResultList();
    }

    @Override
    public List<TrainerSportBO> findServices(Integer idUser) {
        String query = "SELECT * FROM trainer_sport where id_trainer_user = " + idUser + ";";
        Query q = entityManager.createNativeQuery(query, TrainerSportBO.class);

        return q.getResultList();
    }
}
