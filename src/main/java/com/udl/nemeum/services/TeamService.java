package com.udl.nemeum.services;

import com.udl.nemeum.dto.TeamDTO;
import com.udl.nemeum.models.TeamBO;
import com.udl.nemeum.repository.SportRepository;
import com.udl.nemeum.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("teamService")
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private SportRepository sportRepository;

    public List<TeamDTO> getAllTeams(){
        List<TeamBO> teamBOList = teamRepository.findAll();
        return toDTO(teamBOList);
    }

    public TeamDTO getTeam(Integer id){
        return new TeamDTO(teamRepository.findByidTeam(id));
    }

    public void deleteTeam(Integer id){
        if(id != null){
            teamRepository.deleteById(id);
        }
    }

    public TeamDTO addTeam(TeamDTO dto){
        TeamBO bo = toBO(dto);
        TeamBO resultTeam = teamRepository.save(bo);

        return new TeamDTO(resultTeam);
    }

    public TeamDTO modifyTeam(TeamDTO dto){
        TeamBO bo = toBO(dto);
        bo.setIdTeam(dto.getIdTeam());

        TeamBO teamModified = teamRepository.save(bo);
        return new TeamDTO(teamModified);
    }

    private TeamBO toBO(TeamDTO input){
        TeamBO bo = new TeamBO();
        bo.setNameTeam(input.getNameTeam());
        bo.setSport(sportRepository.findByidSport(input.getIdSport()));

        return bo;
    }
    private List<TeamDTO> toDTO(List<TeamBO> teamBOList){
        List<TeamDTO> teamDTOList = new ArrayList<>();
        for(TeamBO scenario : teamBOList ){
            teamDTOList.add(new TeamDTO(scenario));
        }
        return teamDTOList;
    }
}
