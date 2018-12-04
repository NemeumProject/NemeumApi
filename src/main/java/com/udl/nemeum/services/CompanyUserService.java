package com.udl.nemeum.services;

import com.udl.nemeum.dto.CompanyUserDTO;
import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.repository.CompanyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("companyUserService")
public class CompanyUserService {

    @Autowired
    private CompanyUserRepository companyUserRepository;

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

    public CompanyUserDTO add(CompanyUserDTO dto){
        CompanyUserBO bo = toBO(dto);
        CompanyUserBO resultCompanyUser = companyUserRepository.save(bo);

        return new CompanyUserDTO(resultCompanyUser);
    }

    public CompanyUserDTO modify(CompanyUserDTO dto){
        CompanyUserBO bo = toBO(dto);
        bo.setIdCompanyUser(dto.getIdCompanyUser());

        CompanyUserBO resultCompanyUser = companyUserRepository.save(bo);

        return new CompanyUserDTO(resultCompanyUser);
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
