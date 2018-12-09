package com.udl.nemeum.controller;

import com.udl.nemeum.dto.CompanyUserDTO;
import com.udl.nemeum.services.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/companyuser")
public class CompanyUserController {

    @Autowired
    private CompanyUserService companyUserService;

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CompanyUserDTO>> getAllUsers() throws IOException {
        List<CompanyUserDTO> users = companyUserService.getAllUsersCompany();
        return new ResponseEntity<List<CompanyUserDTO>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteUser(@PathVariable("idUser") Integer id) {
        companyUserService.deleteCompanyUser(id);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public CompanyUserDTO getUser(@PathVariable("idUser") Integer id) {
        return companyUserService.getCompanyUser(id);
    }


    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> add(UriComponentsBuilder ucBuilder, @RequestBody CompanyUserDTO input) {

        Map<String, Object> map = companyUserService.add(input);
        if(map.get("exist").equals(true)){
            return new ResponseEntity<String>("User already exists", HttpStatus.UNAUTHORIZED);
        }else{
            CompanyUserDTO user = (CompanyUserDTO) map.get("dto");
            return new ResponseEntity<CompanyUserDTO>(user, HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public CompanyUserDTO modify(UriComponentsBuilder ucBuilder, @RequestBody CompanyUserDTO input) {

        return companyUserService.modify(input);

    }
}
