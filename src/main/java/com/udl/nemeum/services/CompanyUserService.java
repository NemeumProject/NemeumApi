package com.udl.nemeum.services;

import com.udl.nemeum.dto.CompanyUserDTO;
import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.repository.CompanyUserRepository;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("companyUserService")
public class CompanyUserService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    public List<CompanyUserDTO> getAllUsersCompany(){
        List<CompanyUserBO> companyUserDTOList = companyUserRepository.findAll();
        return toDTO(companyUserDTOList);
    }

    public CompanyUserDTO getCompanyUser(Integer id){
        return new CompanyUserDTO(companyUserRepository.findByidCompanyUser(id));
    }

    public void deleteCompanyUser(Integer id){
        if(id != null){
            companyUserRepository.deleteById(id);
        }
    }

    public  Map<String, Object> add(CompanyUserDTO dto){
        Map<String, Object> map = new HashMap<>();
        if(individualUserRepository.findByemail(dto.getEmail()) != null || companyUserRepository.findByemail(dto.getEmail()) != null
                || trainerUserRepository.findByemail(dto.getEmail()) != null){
            map.put("exist", true);
        }else{
            map.put("exist", false);
            CompanyUserBO bo = toBO(dto);
            CompanyUserBO resultCompanyUser = companyUserRepository.save(bo);
            map.put("dto", new CompanyUserDTO(resultCompanyUser));
        }


        return map;
    }

    public CompanyUserDTO modify(CompanyUserDTO dto){
        CompanyUserBO bo = companyUserRepository.findByidCompanyUser(dto.getIdCompanyUser());
        CompanyUserBO finalBO = toBOmodify(bo, dto);

        CompanyUserBO resultCompanyUser = companyUserRepository.save(finalBO);

        return new CompanyUserDTO(resultCompanyUser);
    }

    private CompanyUserBO toBOmodify(CompanyUserBO bo, CompanyUserDTO dto){
        if(dto.getAddress() != null){
            bo.setAddress(dto.getAddress());
        }
        if(dto.getCity() != null){
            bo.setCity(dto.getCity());
        }
        if(dto.getComercialName() != null){
            bo.setComercialName(dto.getComercialName());
        }
        if(dto.getCompanyName() != null){
            bo.setCompanyName(dto.getCompanyName());
        }
        if(dto.getContactPerson() != null){
            bo.setContactPerson(dto.getContactPerson());
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

    private CompanyUserBO toBO(CompanyUserDTO dto) {
        CompanyUserBO bo = new CompanyUserBO();
        bo.setAddress(dto.getAddress());

        bo.setCity(dto.getCity());

        bo.setComercialName(dto.getComercialName());

        bo.setCompanyName(dto.getCompanyName());

        bo.setContactPerson(dto.getContactPerson());

        bo.setEmail(dto.getEmail());

        bo.setPassword(dto.getPassword());

        bo.setPhone(dto.getPhone());

        bo.setPostalCode(dto.getPostalCode());

        bo.setPremium(dto.getPremium());

        bo.setSsn(dto.getSsn());
        bo.setUsername(dto.getUsername());
        bo.setTitle(dto.getTitle());
        bo.setDescription(dto.getDescription());
        bo.setImage(dto.getImage());

        return bo;
    }

    public List<CompanyUserDTO> toDTO(List<CompanyUserBO> companyUserBOList){
        List<CompanyUserDTO> companyUserDTOList = new ArrayList<>();
        for(CompanyUserBO companyUserBO : companyUserBOList){
            companyUserDTOList.add(new CompanyUserDTO(companyUserBO));
        }

        return companyUserDTOList;
    }
}
