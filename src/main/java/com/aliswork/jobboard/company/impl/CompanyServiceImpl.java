package com.aliswork.jobboard.company.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aliswork.jobboard.company.Company;
import com.aliswork.jobboard.company.CompanyRepository;
import com.aliswork.jobboard.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRepository companyRepository;
    
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optional = companyRepository.findById(id);
        if (optional.isPresent()){
            Company company = optional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    
}
