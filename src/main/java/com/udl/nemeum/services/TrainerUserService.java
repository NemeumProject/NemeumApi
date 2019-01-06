package com.udl.nemeum.services;

import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.dto.TrainerUserDTO;
import com.udl.nemeum.models.TrainerSportBO;
import com.udl.nemeum.models.TrainerUserBO;
import com.udl.nemeum.repository.CompanyUserRepository;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("trainerUserService")
public class TrainerUserService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    public List<TrainerUserDTO> getAllUsers(){
        List<TrainerUserBO> trainerUserBOList = trainerUserRepository.findAll();
        return toDTO(trainerUserBOList);
    }

    private List<TrainerUserDTO> toDTO(List<TrainerUserBO> trainerUserBOList) {

        List<TrainerUserDTO> trainerUserDTOList = new ArrayList<>();
        for(TrainerUserBO trainerUserBO : trainerUserBOList ){
            trainerUserDTOList.add(new TrainerUserDTO(trainerUserBO));
        }
        return trainerUserDTOList;
    }

    public TrainerUserDTO getUser(Integer id){
        return new TrainerUserDTO(trainerUserRepository.findByidTrainerUser(id));
    }

    public  Map<String, Object> addUser(TrainerUserDTO input){
        Map<String, Object> map = new HashMap<>();
        if(individualUserRepository.findByemail(input.getEmail()) != null || companyUserRepository.findByemail(input.getEmail()) != null
                || trainerUserRepository.findByemail(input.getEmail()) != null){
            map.put("exist", true);
        }else{
            map.put("exist", false);
            TrainerUserBO bo = toBO(input);
            TrainerUserBO resultTrainerUser = trainerUserRepository.save(bo);
            map.put("dto", new TrainerUserDTO(resultTrainerUser));
        }

        return map;
    }

    public TrainerUserBO toBOModify(TrainerUserBO bo, TrainerUserDTO dto){
        if(dto.getAddress() != null){
            bo.setAddress(dto.getAddress());
        }
        if(dto.getCity() != null){
            bo.setCity(dto.getCity());
        }
        if(dto.getFirstName() != null){
            bo.setFirstName(dto.getFirstName());
        }
        if(dto.getMiddleSurname() != null){
            bo.setMiddleSurname(dto.getMiddleSurname());
        }
        if(dto.getLastSurname() != null){
            bo.setLastSurname(dto.getLastSurname());
        }
        if(dto.getTeachedHours() != null){
            bo.setTeachedHours(dto.getTeachedHours());
        }
        if(dto.getEmail() != null){
            bo.setEmail(dto.getEmail());
        }
        if(dto.getPassword() != null){
            bo.setPassword(dto.getPassword());
        }
        if(dto.getPhone() != null){
            bo.setPhone(dto.getPhone());
        }
        if(dto.getPostalCode() != null){
            bo.setPostalCode(dto.getPostalCode());
        }
        if(dto.getPremium() != null){
            bo.setPremium(dto.getPremium());
        }
        if(dto.getSsn() != null){
            bo.setSsn(dto.getSsn());
        }
        if(dto.getUsername() != null){
            bo.setUsername(dto.getUsername());
        }
        if(dto.getTitle() != null){
            bo.setTitle(dto.getTitle());
        }
        if(dto.getDescription() != null){
            bo.setDescription(dto.getDescription());
        }
        if(dto.getImage() != null){
            bo.setImage(dto.getImage());
        }
        return bo;
    }

    public TrainerUserDTO modifyUser(TrainerUserDTO input){
        TrainerUserBO trainerUserBO = trainerUserRepository.findByidTrainerUser(input.getIdTrainerUser());
        trainerUserBO = toBOModify(trainerUserBO, input);

        TrainerUserBO finalUser = trainerUserRepository.save(trainerUserBO);

        return new TrainerUserDTO(finalUser);
    }

    public void deleteUser(Integer id){
        if(id != null){
            trainerUserRepository.deleteById(id);
        }

    }

    /*public List<TrainerUserDTO> getTrainersBySport(Integer idSport){
        List<TrainerUserBO> trainerUserBOList = trainerUserRepository.findTrainersBySport(idSport);

        return toDTO(trainerUserBOList);
    }*/

    public TrainerUserBO toBO(TrainerUserDTO dto){
        TrainerUserBO trainerUserBO = new TrainerUserBO();
        trainerUserBO.setAddress(dto.getAddress());
        trainerUserBO.setCity(dto.getCity());
        trainerUserBO.setDescription(dto.getDescription());
        trainerUserBO.setEmail(dto.getEmail());
        trainerUserBO.setFirstName(dto.getFirstName());
        trainerUserBO.setLastSurname(dto.getLastSurname());
        trainerUserBO.setMiddleSurname(dto.getMiddleSurname());
        trainerUserBO.setPassword(dto.getPassword());
        trainerUserBO.setPhone(dto.getPhone());
        trainerUserBO.setPostalCode(dto.getPostalCode());
        trainerUserBO.setPremium(dto.getPremium());
        trainerUserBO.setSsn(dto.getSsn());
        trainerUserBO.setTeachedHours(dto.getTeachedHours());
        trainerUserBO.setUsername(dto.getUsername());

        return trainerUserBO;
    }
}
