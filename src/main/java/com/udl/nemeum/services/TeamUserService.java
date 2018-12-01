package com.udl.nemeum.services;

import com.udl.nemeum.dto.TeamUserDTO;
import com.udl.nemeum.models.TeamUserBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TeamRepository;
import com.udl.nemeum.repository.TeamUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teamUserService")
public class TeamUserService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private TeamUserRepository teamUserRepository;

    public TeamUserDTO add(TeamUserDTO dto){
        TeamUserBO teamUserBO = new TeamUserBO();

        teamUserBO.setTeam(teamRepository.findByidTeam(dto.getIdTeam()));
        teamUserBO.setUser(individualUserRepository.findByidIndividualUser(dto.getIdUser()));

        return new TeamUserDTO(teamUserRepository.save(teamUserBO));
    }

    public void deleteTeamUser(Integer idUser, Integer idTeam) {
        if(idTeam != null && idUser != null){
            TeamUserBO teamUserBO = teamUserRepository.finTeamUserByTeamUser(idUser, idTeam);
            teamUserRepository.delete(teamUserBO);
        }

    }
}
