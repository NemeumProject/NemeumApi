package com.udl.nemeum.controller;

import com.udl.nemeum.dto.CompanyUserDTO;
import com.udl.nemeum.dto.FilterScenarioByFacilityDTO;
import com.udl.nemeum.dto.FilterScenarioDTO;
import com.udl.nemeum.dto.ScenarioDTO;
import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.services.CompanyUserService;
import com.udl.nemeum.services.ScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/scenario")
public class ScenarioController {

    @Autowired
    private ScenarioService scenarioService;

    @Autowired
    private CompanyUserService companyUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ScenarioDTO>> getAllScenarios() throws IOException {
        List<ScenarioDTO> scenarios = scenarioService.getAllScenarios();
        return new ResponseEntity<List<ScenarioDTO>>(scenarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idScenario}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteScenario(@PathVariable("idScenario") Integer id) {
        scenarioService.deleteScenario(id);
    }

    @RequestMapping(value = "/{idScenario}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ScenarioDTO getScenario(@PathVariable("idScenario") Integer id){
        return scenarioService.getScenario(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ScenarioDTO add(UriComponentsBuilder ucBuilder, @RequestBody ScenarioDTO input) {

        return scenarioService.addScenario(input);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ScenarioDTO modify(UriComponentsBuilder ucBuilder, @RequestBody ScenarioDTO input) {

        return scenarioService.modifyScenario(input);

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<ScenarioDTO> search(UriComponentsBuilder ucBuilder, @RequestBody FilterScenarioDTO input) {

        return scenarioService.getScenarioWithFilter(input);

    }

    @RequestMapping(value = "/search/facility", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<ScenarioDTO> searchByFacility(UriComponentsBuilder ucBuilder, @RequestBody FilterScenarioByFacilityDTO input) {

        return scenarioService.getScenarioWithFilterFacility(input);

    }

    @RequestMapping(value = "/company/{idCompany}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<ScenarioDTO> getScenariosOfCompany(@PathVariable("idCompany") Integer id){

        return scenarioService.getScenariosByCompany(id);
    }
}
