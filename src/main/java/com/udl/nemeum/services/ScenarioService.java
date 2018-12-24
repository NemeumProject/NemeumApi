package com.udl.nemeum.services;

import com.udl.nemeum.dto.FilterScenarioDTO;
import com.udl.nemeum.dto.ScenarioDTO;
import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.models.SportBO;
import com.udl.nemeum.repository.ScenarioRepository;
import com.udl.nemeum.repository.ScenarioRepositoryImpl;
import com.udl.nemeum.repository.SportRepository;
import com.udl.nemeum.repository.CompanyUserRepository;
import com.udl.nemeum.repository.UserScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("scenarioService")
public class ScenarioService {

    @Autowired
    private ScenarioRepository scenarioRepository;

    @Autowired
    private ScenarioRepositoryImpl scenarioRepositoryImpl;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private UserScenarioRepository userScenarioRepository;

    public List<ScenarioDTO> getAllScenarios(){
        List<ScenarioBO> scenarioBOS = scenarioRepository.findAll();
        return toDTO(scenarioBOS);
    }

    public ScenarioDTO getScenario(Integer id){
        return new ScenarioDTO(scenarioRepository.findByidScenario(id));
    }

    public void deleteScenario(Integer id){

        scenarioRepository.deleteById(id);
    }

    public ScenarioDTO addScenario(ScenarioDTO input) {
        ScenarioBO scenario = toBO(input);
        ScenarioBO resultScenario = scenarioRepository.save(scenario);

        return new ScenarioDTO(resultScenario);
    }

    private ScenarioBO toBO(ScenarioDTO dto){
        ScenarioBO bo = new ScenarioBO();
        bo.setIdCompany(companyUserRepository.findByidCompanyUser(dto.getIdCompany()));
        bo.setCapacity(dto.getCapacity());
        bo.setDateScenario(dto.getDateScenario());
        bo.setIdSport(sportRepository.findByidSport(dto.getIdSport()));
        bo.setIndoor(dto.getIndoor());
        bo.setPrice(dto.getPrice());
        bo.setDescription(dto.getDescription());
        bo.setTitle(dto.getTitle());
        bo.setAddress(dto.getAddress());
        bo.setImage(dto.getImage());

        return bo;
    }

    private List<ScenarioDTO> toDTO(List<ScenarioBO> scenarioBO){
        List<ScenarioDTO> scenarioDTO = new ArrayList<>();
        for(ScenarioBO scenario : scenarioBO ){
            scenarioDTO.add(new ScenarioDTO(scenario));
        }
        return scenarioDTO;
    }

    public ScenarioDTO modifyScenario(ScenarioDTO input) {
        ScenarioBO scenario = toBO(input);
        scenario.setIdScenario(input.getIdScenario());
        ScenarioBO resultScenario = scenarioRepository.save(scenario);

        return new ScenarioDTO(resultScenario);
    }

    public List<ScenarioDTO> getScenariosByCompany(Integer id){
        CompanyUserBO user = companyUserRepository.findByidCompanyUser(id);
        return toDTO(user.getScenarios());
    }

    public List<ScenarioDTO> getScenarioWithFilter(FilterScenarioDTO filter){
        String city = null;
        Double price = null;
        SportBO sport = null;
        if(filter.getCity() != null){
            city = filter.getCity();
        }
        if(filter.getIdSport() != null){
            sport = sportRepository.findByidSport(filter.getIdSport());
        }
        if(filter.getPrice() != null){
            price = filter.getPrice();
        }
        List<ScenarioBO> listScenario = scenarioRepositoryImpl.findScenarioByFilter(sport, price, city);

        return toDTO(listScenario);
    }
}
