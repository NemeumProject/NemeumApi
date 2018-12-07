package com.udl.nemeum.services;

import com.udl.nemeum.dto.SportDTO;
import com.udl.nemeum.models.SportBO;
import com.udl.nemeum.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sportService")
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public List<SportDTO> getAllSports(){
        List<SportBO> sportBOList = sportRepository.findAll();
        return toDTO(sportBOList);
    }

    public SportDTO getSport(Integer id){
        return new SportDTO(sportRepository.findByidSport(id));
    }

    public void deleteSport(Integer id){
        if(id != null){
            sportRepository.deleteById(id);
        }
    }

    public SportDTO addSport(SportDTO dto){
        SportBO bo = toBO(dto);
        SportBO resultSport = sportRepository.save(bo);

        return new SportDTO(resultSport);
    }

    public SportDTO modifySport(SportDTO dto){
        SportBO bo = toBO(dto);
        bo.setIdSport(dto.getIdSport());

        SportBO sportModified = sportRepository.save(bo);
        return new SportDTO(sportModified);
    }

    private SportBO toBO(SportDTO input){
        SportBO bo = new SportBO();
        bo.setMaxPlayers(input.getMaxPlayers());
        bo.setName(input.getName());
        bo.setTeamSport(input.getTeamSport());

        return bo;
    }
    private List<SportDTO> toDTO(List<SportBO> sportBOList){
        List<SportDTO> sportDTOList = new ArrayList<>();
        for(SportBO sportBO : sportBOList ){
            sportDTOList.add(new SportDTO(sportBO));
        }
        return sportDTOList;
    }
}
